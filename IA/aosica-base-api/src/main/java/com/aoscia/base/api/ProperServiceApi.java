package com.aoscia.base.api;

import com.aoscia.base.dto.ProperDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 用户管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName ProperService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateProper: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/Proper")
public interface ProperServiceApi {

    /**
     * @param map
     * @return List<ProperDTO>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<ProperDto> getList(Map<String, Object> map);

    ProperDto get(String ProperName);

    void insert(ProperDto Proper);

    void update(ProperDto Proper);

    /**
     * @param id
     * @return ProperDTO
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    ProperDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<ProperDTO>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);

    void increase(Map<String, Object> map) throws Exception;
}
