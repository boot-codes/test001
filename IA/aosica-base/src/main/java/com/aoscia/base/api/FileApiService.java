package com.aoscia.base.api;

import com.aoscia.base.dto.FileDto;
import com.aoscia.base.service.FileService;
import com.aoscia.base.service.impl.FileServiceImpl;
import com.aosica.common.bean.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: aosica-base->FileApiService
 * @description: 文件对外服务类
 * @author: dwj
 * @create: 2019-09-16 15:10
 **/
@RestController
public class FileApiService implements FileServiceApi {

    private Logger logger = LoggerFactory.getLogger(FileApiService.class);

    @Autowired
    private FileService fileService;

    /**
     * @description 文件上传
     * @param fileDto
     */
    @Override
    public RequestResult uploadFiles(FileDto fileDto) {
        RequestResult requestResult = null;
        try{
            requestResult =   fileService.uploadFiles(fileDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("文件服务{uploadFiles}接口异常"+e.getMessage());
        }
        return  requestResult;
    }

    /**
     * @description 文件下载
     * @param billId
     * @param type 1：原图；2：缩微图
     * @return
     */
    @Override
    public RequestResult downloadFiles(long billId, int type) {
        RequestResult requestResult = null;
        try{
            requestResult =    fileService.downloadFiles(billId,type);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("文件服务{downloadFiles}接口异常"+e.getMessage());
        }
        return  requestResult;
    }
}
