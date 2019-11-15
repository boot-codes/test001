package com.aoscia.base.mapper;

import com.aoscia.base.dto.ProperDto;
import feign.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->ProperService
 * @description: 属性接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface ProperMapper {

    void insert(ProperDto userDTO);

    ProperDto get(String userName);

    void update(ProperDto userDTO);

    ProperDto selectById(Long id);

    List<ProperDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);

    List<Map<String, Object>> getProperById(Long id);

    void increase(Map<String, Object> map);

    void deleteByModel(@Param("model") Long model);
}
