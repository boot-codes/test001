package com.aosica.agriculture.controller;

import com.aosica.agriculture.service.WebSocketService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @PackgeName com.aosica.lot.controller
 * @ClassName TestController.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 17:00
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 17:00$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Api(tags = "swagger 测试类")
@RestController
public class TestController {


//    @Autowired
//    LotService lotService ;


    /**
     * 群发消息内容
     * @param message
     * @return
     */
    @RequestMapping(value="/sendAll", method= RequestMethod.GET)
    public String sendAllMessage(@RequestParam String message){

        System.out.println("........sendAllMessage...........");
        try {
            WebSocketService.BroadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    @RequestMapping(value="/sendOne", method=RequestMethod.GET)
    public String sendOneMessage(@RequestParam String message ,@RequestParam String id){

        System.out.println("..............sendOneMessage ..............");
        try {
            WebSocketService.sendMessage(message,id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }



//    @ApiOperation(value ="这是一个测试方法，",notes = "这是方法的备注说明")
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name ="id" ,value = "用户id"),
//            @ApiImplicitParam(name = "name",value = "用户姓名")
//    })
////    @ApiResponses(value = {
////            @ApiResponse(code = 200, message = "成功",response = User.class),
////            @ApiResponse(code = 400,message = "请求失败")
////    })
//    @GetMapping("/test01")
//    public RequestResult<LotDto> test01() {
//        //@RequestParam Long id , String name
////        List<LotDto> list = this.lotService.getList();
////        System.out.println("获取到了数据：" +list);
//
////        RequestResult requestResult = RequestResult.buildOkData(list);
////        return  requestResult ;
//        return  null ;
//    }


}
