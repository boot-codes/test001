package com.aoscia.base.mapper;
import com.aoscia.base.dto.AreaDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->AreaService
 * @description: 区域接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface AreaMapper {

    void insert(AreaDto userDTO);

    AreaDto get(String userName);

    void update(AreaDto userDTO);

    AreaDto selectById(Long id);

    List<AreaDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);

    List<AreaDto> getChildren(String id);

    Boolean isRelated(Long id);
}
