package com.aoscia.base.mapper;
import com.aoscia.base.dto.ModelDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->ModelService
 * @description: 模型接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface ModelMapper {

    void insert(ModelDto userDTO);

    ModelDto get(String userName);

    void update(ModelDto userDTO);

    ModelDto selectById(Long id);

    List<ModelDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);

    void deleteById(Long id);
}
