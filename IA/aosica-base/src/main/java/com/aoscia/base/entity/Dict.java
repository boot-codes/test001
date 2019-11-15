package com.aoscia.base.entity;

/**
 * @PackgeName com.aoscia.base.entity
 * @ClassName Dict.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:56
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:56$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */


import lombok.Data;
import lombok.ToString;

/**
 * 功能描述: Dict 对应数据库表里的ai_dict表实体类.
 *
 * @param:
 * @return:
 * @auther: ylp
 * @date: 2019/8/25 9:57
 */

@Data
@ToString
public class Dict {


    private Long id;
    private String type;
    private String name;
    private String value;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
