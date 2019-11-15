package com.aoscia.base.dto;

import com.aosica.common.entity.BaseEntity;
import lombok.Data;

/**
 * @PackgeName com.aoscia.base.dto
 * @ClassName ModelDto.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:47
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:47$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Data
public class ModelDto extends BaseEntity {

    private Long id;
    private String type;
    private String model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model=" + model +
                '}';
    }
}
