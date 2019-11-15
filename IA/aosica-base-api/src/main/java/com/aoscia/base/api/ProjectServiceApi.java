package com.aoscia.base.api;

import com.aoscia.base.dto.ProjectDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 工程管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName ProjectService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/project")
public interface ProjectServiceApi {

    /**
     * @param map
     * @return List<ProjectDto>
     * @description 设备列表
     */
    @GetMapping("/list")
    List<ProjectDto> getList(Map<String, Object> map);

    ProjectDto get(String userName);

    void insert(ProjectDto user);

    void update(ProjectDto user);

    /**
     * @param id
     * @return ProjectDto
     * @description 查询用户详细信息
     */
    @RequestMapping("selectById")
    ProjectDto selectById(Long id);

    void delete(List<Long> ids);

    /**
     * @param map
     * @return List<ProjectDto>
     * @description 设备列表
     */
    //@GetMapping("/list")
    void updateById(Map<String, Object> map);

    int getListCount(Map<String, Object> map);
}
