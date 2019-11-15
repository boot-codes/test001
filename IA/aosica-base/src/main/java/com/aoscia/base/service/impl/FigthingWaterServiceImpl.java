package com.aoscia.base.service.impl;

import com.aoscia.base.dto.FightingWaterDto;
import com.aoscia.base.mapper.FightingWaterMapper;
import com.aoscia.base.service.FightingWaterService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ai-planting->FigthingWaterServiceImpl
 * @description: 消防水源实现类
 * @author: dwj
 * @create: 2019-09-26 15:17
 **/
@Service
public class FigthingWaterServiceImpl implements FightingWaterService {

    @Autowired
    private FightingWaterMapper fightingWaterMapper;

    /**
     * @desc 获取消防水源列表
     * @param fightingWaterDto
     * @return
     */
    @Override
    public RequestResult selectList(FightingWaterDto fightingWaterDto) {
        Map<String,Object> map = new HashMap<String, Object>();
        try{
          //  Integer pageNum = fightingWaterDto.getPageNum();
          //  Integer rowNum = fightingWaterDto.getPageSize();
            System.out.println(fightingWaterDto);
            System.out.println("-----查询总数之前-----");
            System.out.println(fightingWaterDto);
            Integer count = 0;//fightingWaterMapper.queryCount(fightingWaterDto);


            System.out.println("-----查询总数之后-----");
            if(count > 0){
                // 每页的第一条记录的索引
            //    int startRow = (pageNum - 1) * (rowNum);
             //   fightingWaterDto.setStartRow(startRow);
                System.out.println("-----查询列表之前-----");
                System.out.println(fightingWaterDto);
               List<FightingWaterDto> list = null;//fightingWaterMapper.queryList(fightingWaterDto);
                System.out.println("-----查询列表之后-----");
                map.put("data",list);
            }
            map.put("total",count);
        }catch (Exception e){
            throw new AosicaException("获取消防水源列表异常"+e.getMessage(),e);
        }
        return RequestResult.buildOkData(map);
    }








    public RequestResult list(HashMap<String,Object> fightingWater){

        Map<String,Object> map = new HashMap<String, Object>();
        try{
            System.out.println(fightingWater);
            Integer pageNum = (Integer) fightingWater.get("pageNum");
            Integer pageSize = (Integer) fightingWater.get("pageSize");
            //startRow
            //Integer rowNum = fightingWaterDto.getPageSize();
            System.out.println(fightingWater);
            System.out.println("-----查询总数之前-----");
            System.out.println(fightingWater);
            Integer count = fightingWaterMapper.queryCount(fightingWater);

           /* if(null==count){
                count =0;
            }*/
            System.out.println("-----查询总数之后-----");
            if(count > 0){
                // 每页的第一条记录的索引
                int startRow = (pageNum - 1) * (pageSize);
                fightingWater.put("startRow",startRow);
                //   fightingWaterDto.setStartRow(startRow);
                System.out.println("-----查询列表之前-----");
                System.out.println(fightingWater);
                List<FightingWaterDto> list = fightingWaterMapper.queryList(fightingWater);
                System.out.println("-----查询列表之后-----");
                map.put("data",list);
            }
            map.put("total",count);
        }catch (Exception e){
            throw new AosicaException("获取消防水源列表异常"+e.getMessage(),e);
        }
        return RequestResult.buildOkData(map);
    }




    /**
     * @desc 查看详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println(id);
        if(StringUtils.isBlank(id)){
            throw new AosicaException("水源Id不能为空");
        }
        System.out.println("-----查看消防水源详细信息之前-----");
        FightingWaterDto dto = fightingWaterMapper.queryById(id);
        System.out.println(dto);
        System.out.println("-----查看消防水源详细信息之后-----");

        return RequestResult.buildOkData(dto);
    }

    /**
     * @desc 新增或修改消防水源
     * @param fightingWaterDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(FightingWaterDto fightingWaterDto) {
        System.out.println("-----进入FigthingWaterServiceImpl--6-------");
        System.out.println(fightingWaterDto);
        long id = fightingWaterDto.getId();
        if(id == 0){
            id = IdWorker.generateId();
            fightingWaterDto.setId(id);
        //    fightingWaterDto.setCreateTime(new Date());
            System.out.println("-----插入水源之前-----");
            fightingWaterMapper.insert(fightingWaterDto);
            System.out.println(fightingWaterDto);
            System.out.println("-----插入水源之后-----");
        }else {
         //   fightingWaterDto.setUpdateTime(new Date());
            System.out.println("-----更新水源之前-----");
            fightingWaterMapper.update(fightingWaterDto);
            System.out.println(fightingWaterDto);
            System.out.println("-----更新水源之后-----");
        }
        return RequestResult.buildOK();
    }
    /**
     * @desc 删除消防水源
     * @param id
     * @return
     */
    @Override
    public RequestResult remove(String id) {
        fightingWaterMapper.remove(id);
        return  RequestResult.buildOK();
    }
}
