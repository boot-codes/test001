package com.aoscia.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: ai-planting->FileDto
 * @description: 文件传输对象
 * @author: dwj
 * @create: 2019-09-16 14:31
 **/
@Data
@ApiModel("文件类")
public class FileDto {

    /**
     * @Fields files 文件对象
     * */
    @ApiModelProperty(value = "文件对象")
    private MultipartFile[] files;
    /**
     *@Fields saveDbPath 文件保存路径
     **/
    @ApiModelProperty(value = "文件上传保存路径")
    private String saveDbPath;
    /**
     *@Fields  billId 业务Id
     **/
    @ApiModelProperty(value = "关联业务Id")
    private long billId;
}
