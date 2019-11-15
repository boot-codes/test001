package com.aoscia.base.api;

import com.aoscia.base.dto.DictDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 字典管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName DictService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/dict")
public interface DictServiceApi {

    /**
     * @param map
     * @return List<DictDto>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<DictDto> getList(Map<String, Object> map);

    DictDto get(String userName);

    void insert(DictDto user);

    void update(DictDto user);

    /**
     * @param id
     * @return DictDto
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    DictDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<DictDto>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);

    List<DictDto> getById(String type);
}
