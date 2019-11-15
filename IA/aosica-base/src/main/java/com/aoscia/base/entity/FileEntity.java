package com.aoscia.base.entity;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @program: ai-planting->FileEntity
 * @description: 文件对象
 * @author: dwj
 * @create: 2019-09-16 14:56
 **/
@Data
public class FileEntity extends BaseEntity {

    /**
     * @Fields id
     **/
    private long id;
    /**
     * @Fields 文件名
     **/
    private String name;
    /**
     * @Fields 文件类型
     **/
    private String type;
    /**
     * @Fields 文件路径
     **/
    private String path;
    /**
     * @Fields 业务Id
     **/
    private long billId;
    /**
     * @Fields 文件大小
     **/
    private String size;

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", billId=" + billId +
                ", size='" + size + '\'' +
                '}';
    }
}
