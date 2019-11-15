package com.aosica.user.entity;

/**
 * @PackgeName com.aoscia.base.entity
 * @ClassName Menu.java
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
 * 功能描述: Menu 对应数据库表里的ai_menu表实体类.
 *
 * @param:
 * @return:
 * @auther: ylp
 * @date: 2019/8/25 9:57
 */

@Data
@ToString
public class Menu {


    private Long id;

    private String menuCode;

    private String parMenuCode;

    private String menuName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getParMenuCode() {
        return parMenuCode;
    }

    public void setParMenuCode(String parMenuCode) {
        this.parMenuCode = parMenuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
