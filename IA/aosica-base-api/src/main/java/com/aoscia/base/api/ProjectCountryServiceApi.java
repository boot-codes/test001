package com.aoscia.base.api;

import com.aoscia.base.dto.CountryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 用户管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName ProjectCountryService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/projectCountry")
public interface ProjectCountryServiceApi {

    /**
     * @param map
     * @return List<CountryDto>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<CountryDto> getList(Map<String, Object> map);

    CountryDto get(String userName);

    void insert(CountryDto user);

    void update(CountryDto user);

    /**
     * @param id
     * @return CountryDto
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    CountryDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<CountryDto>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);
}
