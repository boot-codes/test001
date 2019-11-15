package com.aosica.lot.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 设备系统类型查询DTO
 * @PackgeName com.aosica.lot.dto
 * @ClassName DeviceSystemTypeQueryDTO.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 16:09
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 16:09$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@ApiModel(description = "设备系统类型查询DTO")
public class DeviceSystemTypeQueryDTO {

    @ApiModelProperty(value = "主键id")
    private Long id ;

    @ApiModelProperty(value = "系统类型名称")
    private String systemTypeName;

    @ApiModelProperty(value = "系统类型编码")
    private String systemTypeCode;


    @ApiModelProperty(value = "排序方式")
    private String orderByClause ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemTypeName() {
        return systemTypeName;
    }

    public void setSystemTypeName(String systemTypeName) {
        this.systemTypeName = systemTypeName;
    }

    public String getSystemTypeCode() {
        return systemTypeCode;
    }

    public void setSystemTypeCode(String systemTypeCode) {
        this.systemTypeCode = systemTypeCode;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Override
    public String toString() {
        return "DeviceSystemTypeQueryDTO{" +
                "id=" + id +
                ", systemTypeName='" + systemTypeName + '\'' +
                ", systemTypeCode='" + systemTypeCode + '\'' +
                '}';
    }
}
