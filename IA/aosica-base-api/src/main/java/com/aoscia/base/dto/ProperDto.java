package com.aoscia.base.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName ProperDto.java
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
public class ProperDto extends BaseEntity {

    private Long id;
    private String proper;
    private Long model;
    private String unit;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProper() {
        return proper;
    }

    public void setProper(String proper) {
        this.proper = proper;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
