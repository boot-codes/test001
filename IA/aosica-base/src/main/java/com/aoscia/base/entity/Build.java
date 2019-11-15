package com.aoscia.base.entity;

/**
 * @PackgeName com.aoscia.base.entity
 * @ClassName Build.java
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
 * 功能描述: Build 对应数据库表里的ai_build表实体类.
 *
 * @param:
 * @return:
 * @auther: ylp
 * @date: 2019/8/25 9:57
 */

@Data
@ToString
public class Build {

    private Long id;
    private String buildName;
    private String manager;
    private String longitude;
    private String latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
