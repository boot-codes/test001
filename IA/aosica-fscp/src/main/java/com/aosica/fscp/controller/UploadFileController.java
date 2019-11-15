package com.aosica.fscp.controller;

import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: aosica-fscp->UploadFileController
 * @description: 上传文件controller(将文件保存到静态文件服务器)
 * @author: ll
 * @create: 2019-11-12 14:32
 **/
@Api(tags = "上传文件controller api")
@RequestMapping("uploadFile")
@RestController
public class UploadFileController {

    @RequestMapping(value = "picture")
    @ResponseBody
    public RequestResult uploadPicture(MultipartFile  file) throws IOException {
        System.out.println("进入UploadFileController");
        File dirFile = new File("D:/dir/" + file.getOriginalFilename());
        file.transferTo(dirFile);
        return RequestResult.buildOkData("picture/2019/11/12/14/38/"+file.getOriginalFilename());
    }
}
