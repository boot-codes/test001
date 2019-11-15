package com.aoscia.base.service.impl;

import com.aoscia.base.dto.BuildingImportantPartEntity;
import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aoscia.base.mapper.BuildingSecurityMassageMapper;
import com.aoscia.base.service.BuildingSecurityMassageService;
import com.aosica.common.config.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ai-planting->BuildingSecurityMassageServiceImpl
 * @description: 建筑物安全管理信息ServiceImpl
 * @author: ll
 * @create: 2019-11-11 15:06
 **/
@Service
public class BuildingSecurityMassageServiceImpl implements BuildingSecurityMassageService {

    @Autowired
    private BuildingSecurityMassageMapper mapper;

    @Override
    public BuildingSecurityMassageDto queryBuildingSecurityMassageByBuildingId(String buildingId) {

        return mapper.queryBuildingSecurityMassageByBuildingId(buildingId);
    }

    @Override
    public void update(BuildingSecurityMassageDto dto) {
        System.out.println("进入BuildingSecurityMassageServiceImpl");
        //获取更新之前的重点部位信息
        List<BuildingImportantPartEntity> preBuildingImportantPartEntities = mapper.queryImportantPartByBuildingId(dto.getId().toString());

        //获取更新之后的重点部位信息
        List<BuildingImportantPartEntity> newBuildingImportantPartEntitys = dto.getBuildingImportantPartEntitys();
        //删除多余的重点部位信息(删除的重点部位信息=之前的重点部位信息-之后的重点部位信息)
        if(preBuildingImportantPartEntities.isEmpty()){
            // 插入或更新重点部位信息表
            for (BuildingImportantPartEntity entity : newBuildingImportantPartEntitys ) {
                if(null == entity.getId()||0L==entity.getId()){
                    long id = IdWorker.generateId();
                    entity.setId(id);
                    mapper.insertImportantPart(entity);
                }else{
                    mapper.updateImportantPart(entity);
                }
            }
        }


        else{
            boolean firstRound = true;
            for (BuildingImportantPartEntity preEntity : preBuildingImportantPartEntities) {
                boolean toDelete = true;
                for (BuildingImportantPartEntity newEntity : newBuildingImportantPartEntitys) {
                    if(null == newEntity.getId()||0L==newEntity.getId()) {
                        //插入
                        long id = IdWorker.generateId();
                        newEntity.setId(id);
                        mapper.insertImportantPart(newEntity);
                    }else if(preEntity.getId()==newEntity.getId()){
                        //更新
                        mapper.updateImportantPart(newEntity);
                        toDelete = false;
                        //第一轮先全部扫描一遍,目的是将所有应该插入的entity全部插入
                        if(!firstRound){
                            break;
                        }
                    }
                }
                if(toDelete){
                    //删除
                    mapper.removeBuildingImportantPart(preEntity.getId().toString());
                }
                if(firstRound){
                    firstRound=false;
                }
            }
        }
        /*System.out.println(preBuildingImportantPartEntities);
        System.out.println(preBuildingImportantPartEntities.get(0));
        for (int i=0;i<=preBuildingImportantPartEntities.size();i++){

        }*/




        /*// 插入或更新重点部位信息表
        for (BuildingImportantPartEntity entity : newBuildingImportantPartEntitys ) {
            if(null == entity.getId()||0L==entity.getId()){
                long id = IdWorker.generateId();
                entity.setId(id);
                mapper.insertImportantPart(entity);
            }else{
                mapper.updateImportantPart(entity);
            }
        }*/
        //更新建筑物表
        mapper.update(dto);
    }

    @Override
    public void insertImportantPart(BuildingImportantPartEntity dto) {
    //mapper.insertImportantPart(dto);
    }

    @Override
    public void updateImportantPart(BuildingImportantPartEntity dto) {
   // mapper.updateImportantPart(dto);
    }

    @Override
    public void removeBuildingImportantPart(String importantPartId) {
    //mapper.removeBuildingImportantPart(importantPartId);
    }
}
