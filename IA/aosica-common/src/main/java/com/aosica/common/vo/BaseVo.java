package com.aosica.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: ai-planting->BaseVo
 * @description: 展示对象基类
 * @author: Windows10
 * @create: 2019-08-23 10:06
 **/
@Data
public class BaseVo implements Serializable {
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 620798494072148127L;
    private String id;

    private String name;
}
