package com.aoscia.base.api;

import com.aoscia.base.dto.DeptDto;
import com.aosica.common.bean.RequestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 机构管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName DeptService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@RequestMapping("/dept")
public interface DeptServiceApi {

    /**
     * @desc 查询机构信息
     * @param projectId
     */
    @ApiOperation(value = "查询机构信息",notes = "")
    @ApiImplicitParam(name = "项目id",value = "projectId")
    @PostMapping("selectList")
    RequestResult selectList(@RequestParam(value = "projectId") String projectId);


    @ApiOperation(value = "新增机构",notes = "")
    @ApiImplicitParam(dataTypeClass = DeptDto.class)
    @PostMapping("save")
    RequestResult save(DeptDto deptDto);

}
