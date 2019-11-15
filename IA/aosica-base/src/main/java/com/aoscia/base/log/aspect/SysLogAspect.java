package com.aoscia.base.log.aspect;

import com.aoscia.base.dto.LogDto;
import com.aosica.common.annotation.LogEvict;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.constant.OperationEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ai-planting->SysLogAspect
 * @description: 系统日志：切面处理类
 * @author: dwj
 * @create: 2019-08-30 10:43
 **/
@Aspect
@Component
public class SysLogAspect {

    private static final Logger log = LoggerFactory.getLogger(SysLogAspect.class);


    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.aosica.common.annotation.LogEvict)")
    public void logPoinCut() {
    }

    /**
     * @description 后置通知
     * @param joinPoint
     */
    @AfterReturning(value = "logPoinCut()",returning = "keys")
    public void saveOperation(JoinPoint joinPoint,Object keys) {
        log.info("---------------接口日志记录---------------");
        log.info("调用了后置通知");
        RequestResult obj = (RequestResult)keys;
        int  msg = obj.getStatus();
        if(msg == 200){
            this.excute(joinPoint,"操作成功");
        }else {
            this.excute(joinPoint,"操作失败");
        }
    }

    /**
     * @description 获取请求参数
     * @param joinPoint
     * @return
     */
    Map<String, Object> getNameAndValue(JoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            if(paramValues[i] instanceof HashMap){
                Map<String,Object> map = (Map<String,Object>)paramValues[i];
                map.forEach((key, value) -> {
                    param.put(key,value);
                });
            }else {
                param.put(paramNames[i], paramValues[i]);
            }

        }
        return param;
    }

    private void excute(JoinPoint joinPoint,String result){
        //保存日志
        LogDto operation = new LogDto();
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作--方法上的ViLog的值
        LogEvict logEvict = method.getAnnotation(LogEvict.class);
        String billId = "";
        if (logEvict != null) {
            //保存操作事件
            String operEvent = logEvict.operEvent();
            operation.setResult(operEvent);
            //保存操作说明
            String explain = logEvict.explain();
            operation.setExplain(explain);
            //保存日志类型
            OperationEnum operType = logEvict.operType();
            billId = logEvict.billId();
            operation.setType(operType.getValue());
            log.info("operEvent="+operEvent+",operType="+operType+"explain="+explain+"billId"+billId);
        }
        //TODO 操作人账号、姓名
//        User user = (User) request.getSession().getAttribute(SysUser.SESSION_KEY);
//        if(user != null) {
//            String account = user.getAccount();
//            String username = user.getUsername();
//            operation.setIdentity(account);
//            operation.setUsername(username);
//        }
        //目前没有做登陆 操作人写死admin
        operation.setOperationBy("admin");
        operation.setId(IdWorker.generateId());
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        //获取请求的参数
        Map<String, Object> map = getNameAndValue(joinPoint);
        System.out.println("class name="+className + "." + methodName);

        //操作时间
        operation.setCreateTime(new Date());
        //操作的业务Id
        String str = (String) map.get(billId);
        operation.setBillId(String.valueOf(str));
        operation.setCreateBy(0);
        operation.setResult(result);
        //调用service保存Operation实体类到数据库
//        logServiceApi.save(operation);
    }

}
