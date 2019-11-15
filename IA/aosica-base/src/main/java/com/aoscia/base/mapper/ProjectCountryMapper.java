package com.aoscia.base.mapper;
import com.aoscia.base.dto.CountryDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: aosica-base->ProjectCountryService
 * @description: 国家接口
 * @author: ylp
 * @create: 2019-08-21 19:05
 **/
@Repository
public interface ProjectCountryMapper {

    void insert(CountryDto userDTO);

    CountryDto get(String userName);

    void update(CountryDto userDTO);

    CountryDto selectById(Long id);

    List<CountryDto> getList(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void delete(List<Long> ids);

    int getListCount(Map<String, Object> map);
}
