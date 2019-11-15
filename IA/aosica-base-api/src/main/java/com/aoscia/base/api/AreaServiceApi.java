package com.aoscia.base.api;

import com.aoscia.base.dto.AreaDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 区域管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName AreaService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/area")
public interface AreaServiceApi {

    /**
     * @param map
     * @return List<AreaDto>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<AreaDto> getList(Map<String, Object> map);

    AreaDto get(String userName);

    void insert(AreaDto user);

    void update(AreaDto user);

    /**
     * @param id
     * @return AreaDto
     * @description 查询区域详细信息
     */
    @RequestMapping("selectById")
    AreaDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<AreaDto>
     * @description 区域列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);

    /**
     * @param id
     * @return List<AreaDto>
     * @description 下级区域
     */
    @GetMapping("/getChildren")
    List<AreaDto> getChildren(String id);

    Boolean isRelated(Long id);
}
