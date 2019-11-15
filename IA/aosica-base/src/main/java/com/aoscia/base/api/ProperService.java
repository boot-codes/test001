package com.aoscia.base.api;


import com.aoscia.base.dto.ModelDto;
import com.aoscia.base.dto.ProperDto;
import com.aoscia.base.mapper.ModelMapper;
import com.aosica.common.config.IdWorker;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackgeName com.aosica.ai.planting.service
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 9:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class ProperService implements ProperServiceApi {

    @Autowired
    private com.aoscia.base.mapper.ProperMapper ProperMapper;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(ProperService.class);

    @Override
    public List<ProperDto> getList(Map<String, Object> map) {
        return ProperMapper.getList(map);
    }


    @Override
    public ProperDto get(String userName) {
        return ProperMapper.get(userName);
    }

    @Override
    public void insert(ProperDto user) {
        user.setId(IdWorker.generateId());
        ProperMapper.insert(user);
    }

    @Override
    public void update(ProperDto ProperDTO) {
        ProperMapper.update(ProperDTO);
    }

    @Override
    public ProperDto selectById(Long id) {
        return ProperMapper.selectById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        ProperMapper.delete(ids);
    }

    @Override
    public void updateById(Map<String, Object> map) {
        ProperMapper.updateById(map);
    }

    @Override
    public int getListCount(Map<String, Object> map) {
        return ProperMapper.getListCount(map);
    }

    @Override
    public void increase(Map<String, Object> map) throws Exception {
        ModelDto modelDto = new ModelDto();
        ProperDto properDto = new ProperDto();
        BeanUtils.copyProperties(modelDto, map);
        BeanUtils.copyProperties(properDto, map);
        modelDto.setId(IdWorker.generateId());
        properDto.setId(IdWorker.generateId());
        modelMapper.insert(modelDto);
        ProperMapper.insert(properDto);
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("ids", "1");
        ModelDto modelDto = new ModelDto();
        try {
            BeanUtils.copyProperties(modelDto, map);
            System.out.println(modelDto.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
























