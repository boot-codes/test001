package com.aoscia.base.util;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

//    public static List<MenuDto> getTreeList(List<MenuDto> entityList) {
//        List<MenuDto> resultList = new ArrayList<>();
//        //获取顶层元素集合
////        String parentCode;
////        for (MenuDto entity : entityList) {
////            parentCode = entity.getCode();
////            //顶层元素的parentCode==null或者为0
////            if (parentCode == null || "0".equals(parentCode)) {
////                resultList.add(entity);
////            }
////        }
////        //获取每个顶层元素的子数据集合
////        for (MenuDto entity : resultList) {
////            entity.setChildrenList(getSubList(entity.getCode(), entityList));
////        }
//
//        return resultList;
//    }

    /**
     * 获取子数据集合
     *
     * @param id
     * @param entityList
     * @return
     * @author jianda
     * @date 2017年5月29日
     */
//    private static List<MenuDto> getSubList(String id, List<MenuDto> entityList) {
//        List<MenuDto> childList = new ArrayList<>();
//        String parentId;
//
//        //子集的直接子对象
////        for (MenuDto entity : entityList) {
////            parentId = entity.getParCode();
////            if (id.equals(parentId)) {
////                childList.add(entity);
////            }
////        }
////
////        //子集的间接子对象
////        for (MenuDto entity : childList) {
////            entity.setChildrenList(getSubList(entity.getCode(), entityList));
////        }
////
////        //递归退出条件
////        if (childList.size() == 0) {
////            return null;
////        }
//
//        return childList;
//    }

}