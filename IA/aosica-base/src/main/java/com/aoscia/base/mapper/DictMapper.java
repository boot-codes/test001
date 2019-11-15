package com.aoscia.base.mapper;
import com.aoscia.base.dto.DictDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->DictService
 * @description: 字典接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface DictMapper {

    void insert(DictDto userDTO);

    DictDto get(String userName);

    void update(DictDto userDTO);

    DictDto selectById(Long id);

    List<DictDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> array);

    int getListCount(Map<String, Object> map);

    List<DictDto> getById(String type);
}
