package com.aoscia.base.api;

import com.aoscia.base.dto.ModelDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 模型管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName ModelService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateModel: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/Model")
public interface ModelServiceApi {

    /**
     * @param map
     * @return List<ModelDTO>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<ModelDto> getList(Map<String, Object> map);

    ModelDto get(String ModelName);

    void insert(ModelDto Model);

    void update(ModelDto Model);

    /**
     * @param id
     * @return ModelDTO
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    ModelDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<ModelDTO>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);
}
