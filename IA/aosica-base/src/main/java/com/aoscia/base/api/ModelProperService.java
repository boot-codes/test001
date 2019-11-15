package com.aoscia.base.api;


import com.aoscia.base.dto.ModelDto;
import com.aoscia.base.dto.ProperDto;
import com.aoscia.base.mapper.ModelMapper;
import com.aosica.common.config.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
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
public class ModelProperService implements ModelProperServiceApi {

    @Autowired
    private com.aoscia.base.mapper.ProperMapper ProperMapper;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(ModelProperService.class);

    @Override
    public void increase(Map<String, Object> map) throws Exception {
        ModelDto modelDto = new ModelDto();
        modelDto.setModel(map.get("model").toString());
        Long id = IdWorker.generateId();
        modelDto.setId(id);
        modelMapper.insert(modelDto);

        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("propers");
        for (int i = 0; i < list.size(); i++) {
            ProperDto properDto = new ProperDto();
            properDto.setId(IdWorker.generateId());
            //BeanUtils.copyProperties(properDto, list.get(i));
            properDto.setUnit(list.get(i).get("unit").toString());
            properDto.setProper(list.get(i).get("proper").toString());
            properDto.setModel(id);
            ProperMapper.insert(properDto);
        }
    }

    @Override
    public void update(Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        //修改型号
        ModelDto modelDto = new ModelDto();
        modelDto.setId((Long) map.get("id"));
        modelDto.setModel(map.get("model").toString());
        modelMapper.update(modelDto);
        //List<Long> ids = new ArrayList<>();
        //ids.add((Long) map.get("id"));
        ProperMapper.deleteByModel((Long) map.get("id"));
        //添加
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("propers");
        for (int i = 0; i < list.size(); i++) {
            ProperDto properDto = new ProperDto();
            properDto.setId(IdWorker.generateId());
            //BeanUtils.copyProperties(properDto, list.get(i));
            properDto.setUnit(list.get(i).get("unit").toString());
            properDto.setProper(list.get(i).get("proper").toString());
            properDto.setModel((Long) map.get("id"));
            ProperMapper.insert(properDto);
        }
    }

    @Override
    public List<Map<String, Object>> selectById(Long id) {
        return ProperMapper.getProperById(id);
    }

    @Override
    public void deleteById(Long id) {
        //根据id
        modelMapper.deleteById(id);
        //根据型号id删除属性
        ProperMapper.deleteByModel(id);
    }
}
























