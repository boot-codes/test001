package com.aosica.user.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.user.dto.BuildingResponsiblePersonDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("responsiblePerson")
public interface BuildingResponsiblePersonApi {


    /**
     * @desc 获取建筑物下的所有管理人员
     * @param userIds
     * @return
     */
    @RequestMapping(value = "/queryResponsiblePersonByUserIds" ,method = RequestMethod.POST)
     RequestResult<List<BuildingResponsiblePersonDto>> queryResponsiblePersonByUserIds(@RequestBody String[] userIds);

    /**
     * @desc 根据id获取安全管理人员
     * @param userId
     * @return
     */
    @RequestMapping(value = "/queryResponsiblePersonByUserId/{userId}" ,method = RequestMethod.GET)
     RequestResult<BuildingResponsiblePersonDto> queryResponsiblePersonByUserId(@PathVariable("userId") String userId);


    /**
     * @desc 根据联系电话查询管理人员
     * @param dto
     */
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
     RequestResult<BuildingResponsiblePersonDto> insert(@RequestBody BuildingResponsiblePersonDto dto);

    /**
     * @desc 修改管理人员
     * @param dto
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
     RequestResult update(@RequestBody BuildingResponsiblePersonDto dto);
    
    
}
