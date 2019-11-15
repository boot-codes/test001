package com.aoscia.base.service.impl;

import com.aoscia.base.dto.DeptDto;
import com.aoscia.base.mapper.DeptMapper;
import com.aoscia.base.service.DeptService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: aosica-base->DeptServiceImpl
 * @description: 机构实现类
 * @author: dwj
 * @create: 2019-09-24 16:19
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public RequestResult selectList(String projectId) {
        RequestResult requestResult = null;
//        List<TreeEntity> treeList = new ArrayList<TreeEntity>();
//        try {
//            List<DeptDto> list =  deptMapper.queryListByUserId(projectId);
//            if(!CollectionUtils.isEmpty(list)){
//                for(DeptDto deptDto : list){
//                    TreeEntity treeEntity = new TreeEntity();
//                    long id = deptDto.getId();
//                    String parentId = deptDto.getPId();
//                    String name = deptDto.getName();
//                    treeEntity.setId(String.valueOf(id));
//                    treeEntity.setName(name);
//                    treeEntity.setPId(parentId);
//                    //只显示出二级菜单 一级菜单父id默认为0
//                    if(parentId.equals("0")){
//                        treeEntity.setOpen(true);
//                    }else {
//                        treeEntity.setOpen(false);
//                    }
//                    treeList.add(treeEntity);
//                }
//            }
//            requestResult = RequestResult.buildOkData(treeList);
//        }catch (Exception e){
//        }
//        return requestResult;
        return  null ;
    }

    @Override
    @Transactional(rollbackFor = AosicaException.class)
    public RequestResult save(DeptDto deptDto) {
        if(StringUtils.isBlank(deptDto.getPId())){
            deptDto.setPId("0");
        }
        deptDto.setId(IdWorker.generateId());
        deptDto.setCreateTime(new Date());
        deptMapper.insert(deptDto);
        return RequestResult.buildOK();
    }
}
