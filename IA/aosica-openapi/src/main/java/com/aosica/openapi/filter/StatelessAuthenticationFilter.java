package com.aosica.openapi.filter;

import com.alibaba.fastjson.JSONObject;
import com.aosica.common.bean.RequestResult;
import com.aosica.openapi.util.Constant;
import com.aosica.openapi.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * @author yuzp
 */
@Component
public class StatelessAuthenticationFilter extends BasicHttpAuthenticationFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(StatelessAuthenticationFilter.class) ;

    private final static String LOGIN_URL = "/user/login" ;

    public  final static  String AUTHORIZATION = "Authorization" ;

    private final static String LONG_INFO_INVALID = "登录信息无效，请重新登录!" ;

    private final static String USERNAME_OR_PASS_INVALID = "用户名或密码错误!" ;

    private final static String UNAUTHORIZED_ACCESS = "非法的用户访问" ;

    private final static String REQEUST_FAIL = "请求失败" ;

    //private CacheService cacheService = null ;



    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o)  {
        return false;
    }

    /**
     * 用户请校验
     * @param servletRequest
     * @param servletResponse
     * @return
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse){

        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

       try {
           String requestURI = request.getRequestURI() ;
           LOGGER.info("==>客户端请求URI:"+ requestURI);
           // 获取Header 里的token  并从 从token 中获取用户名
           String token = request.getHeader(AUTHORIZATION);
           String userName = null ;
           if(StringUtils.isBlank(token) || StringUtils.isBlank(userName = JwtUtil.getUsername(token))) {
               accessFail(response,UNAUTHORIZED_ACCESS,HttpStatus.UNAUTHORIZED.value());
               return  false ;
           }


           // 验证token 是否有效。
           boolean verify = JwtUtil.verify(token, userName);
           LOGGER.info("token 是否有效：" +verify +" ===>token = "+token);
           if(!verify) {
               LOGGER.error(LONG_INFO_INVALID);
               accessFail(response, LONG_INFO_INVALID, HttpStatus.UNAUTHORIZED.value());
               return false;
           }
           LOGGER.info("登录用户名："+userName);

        }
        catch (Exception e) {
            // 请求失败
            accessFail(response,REQEUST_FAIL,500);
            return false;
        }
        return true;
    }

    //访问失败处理
    private void accessFail(HttpServletResponse response, String errorMesg, int errorStatus)  {
        LOGGER.error("====>"+errorStatus +" ," +errorMesg);
        response.setCharacterEncoding("utf-8");
        response.setStatus(errorStatus);
        response.setContentType(Constant.APPLICATION_JSON);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("expires", -1);
        PrintWriter writer = null ;
        try {
            writer = response.getWriter();
            writer.write(JSONObject.toJSONString(RequestResult.build(errorStatus, errorMesg)));
            writer.flush();
        }
        catch (Exception ei) {
            LOGGER.error("请求失败" ,ei);
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
    }


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }


    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {
        //currentLoginUser.remove();
        //RequestContext.getCurrentContext().unset();
    }


    //public static ThreadLocal<String> getCurrentLoginUser() {
    //    return currentLoginUser;
    //}

}
