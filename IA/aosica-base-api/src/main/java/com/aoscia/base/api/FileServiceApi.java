package com.aoscia.base.api;

import com.aoscia.base.dto.FileDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("file")
public interface FileServiceApi {

    /**
     * @description 上传文件
     * @param fileDto
     */
    @ApiOperation(value = "上传文件",notes = "")
    @ApiImplicitParam(dataTypeClass = FileDto.class)
    @PostMapping("uploadFiles")
    RequestResult uploadFiles(FileDto fileDto);

    /**
     * @description 下载文件
     * @param billId
     * @param type
     * @return List<byte[]>
     */
    @ApiOperation(value = "下载文件",notes = "")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "1：原图；2：缩微图",value = "type"),
            @ApiImplicitParam(name = "业务Id",value = "billId")
    }
    )
    @PostMapping("downloadFiles")
    RequestResult downloadFiles(@RequestParam(value = "billId")long billId, @RequestParam(value = "type")int type);
}
