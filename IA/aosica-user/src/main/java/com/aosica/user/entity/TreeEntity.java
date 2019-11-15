package com.aosica.user.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: ai-planting->TreeEntity
 * @description: 树形结构
 * @author: dwj
 * @create: 2019-09-24 16:34
 **/
@Data
@ToString
public class TreeEntity implements Serializable {

    private static final long serialVersionUID = 2476518309140979290L;

    private String id;
    private String pId;                // 父节点id
    private String name;               // 树节点名称
    private Boolean checked = false;   // 是否勾选状态
    private Boolean open = false;      //是否展开
    private String icon;               //图标，可以自定义图标展示
    private Boolean nocheck = false;
    private int isLeaf; //是否是叶子节点 0否1是


}
