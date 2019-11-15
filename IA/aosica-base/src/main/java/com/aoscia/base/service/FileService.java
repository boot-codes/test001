package com.aoscia.base.service;

import com.aoscia.base.dto.FileDto;
import com.aosica.common.bean.RequestResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: aosica-base->FileService
 * @description: 文件接口
 * @author: dwj
 * @create: 2019-09-24 10:10
 **/
public interface FileService {

    /**
     * @description 上传文件
     * @param fileDto
     */
    RequestResult uploadFiles(FileDto fileDto);

    /**
     * @description 下载文件
     * @param billId
     * @param type
     * @return List<byte[]>
     */
    RequestResult downloadFiles(@RequestParam(value = "billId")long billId, @RequestParam(value = "type")int type);
}
