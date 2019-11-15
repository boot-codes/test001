package com.aoscia.base.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName MenuDTO.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:47
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:47$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class DeptDto extends BaseEntity {

    /**
     * @Fields id
     */
    private long id;
    /**
     * @Fields  机构名
     */
    private String name;
    /**
     * @Fields 1 监管单位 2 管理单位
     */
    private int type;
    /**
     * @Fields 父机构
     */
    private String pId;
    /**
     * @Fields 项目id
     */
    private String projectId;
    /**
     * @Fields 服务名
     */
    private String serverName;
    /**
     * @Fields 备注
     */
    private String remark;
}
