package com.aosica.fscp.service.impl;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.fscp.api.BuildingManageService;
import com.aosica.fscp.api.BuildingResponsiblePersonManageService;
import com.aosica.fscp.api.BuildingSecurityMassageManageService;
import com.aosica.fscp.api.FireFightingDeviceService;
import com.aosica.fscp.service.BuildingMassageManageService;
import com.aosica.lot.dto.SystemTypeDTO;
import com.aosica.user.dto.BuildingResponsiblePersonDto;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 建筑物信息Service
 * @author: ll
 * @create: 2019-10-30 18:04
 **/
@Service
public class BuildingMassageManageServiceImpl implements BuildingMassageManageService {

    @Autowired
    private BuildingManageService buildingManageService;

    @Autowired
    private BuildingSecurityMassageManageService buildingSecurityMassageManageService;

    @Autowired
    private BuildingResponsiblePersonManageService buildingResponsiblePersonService;

    @Autowired
    private FireFightingDeviceService deviceService ;

    //Ok
    @Override
    public RequestResultPage<Page<BuildingDto>> selectList(BuildingDto dto) {
        System.out.println("进入BuildingMassageManageServiceImpl--------2-------");
        System.out.println(dto);
        return buildingManageService.selectList(dto);
    }
    //ok
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("进入BuildingServiceImpl------2------");
        RequestResult requestResult = buildingManageService.selectDetailById(id);
        System.out.println(requestResult);
        return  requestResult;
    }
    //doing--ok
    @Override
    public RequestResult selectDetailToManageMassageById(String id) {
        //RequestResult requestResult = selectDetailById(id);
        RequestResult<BuildingDto> requestResult = buildingManageService.selectDetailById(id);
        BuildingDto buildingDto = requestResult.getData();
        Map<Integer,Object> resultMap = new HashMap<>();

        //查询安全负责人
        String safetyDuty = buildingDto.getSafetyDuty();
        RequestResult<BuildingResponsiblePersonDto> safetyDutyResult = buildingResponsiblePersonService.queryResponsiblePersonByUserId(safetyDuty);


        //获取安全管理人
        String safetyManager = buildingDto.getSafetyManager();
        //将安全管理人id装入数组中
        String[] safetyManagers = safetyManager.split(",");
        RequestResult<List<BuildingResponsiblePersonDto>> safetyManagerResult = buildingResponsiblePersonService.queryResponsiblePersonByUserIds(safetyManagers);
        //封装返回数据
        resultMap.put(0,safetyDutyResult.getData());
        resultMap.put(1,safetyManagerResult.getData());
        return RequestResult.buildOkData(resultMap);

    }



    //doing------注意,工程id没有解决-----ok
    @Override
    public RequestResult selectDetailToFireSafeMassageById(String id) {

        //获取该建筑物配备的系统类型
        RequestResult<List<SystemTypeDTO>> systemTypes = deviceService.getSystemTypeByBuildId("1000", Long.valueOf(id));

        //获取消防安全信息
        RequestResult<BuildingSecurityMassageDto> requestResult = buildingSecurityMassageManageService.queryBuildingSecurityMassageByBuildingId(id);
        //封装返回数据
        requestResult.getData().setFireFacilitiesList(systemTypes.getData());
        System.out.println(systemTypes);
        return requestResult;
    }

    //ok
    @Override
    public RequestResult updateDetail(BuildingDto dto) {

        return buildingManageService.update(dto);
    }

    //doing--ok
    @Override
    public RequestResult updateDetailToManageMassage(List<BuildingResponsiblePersonDto> dtos, String buildingId) {
        System.out.println("进入updateDetailToManageMassage");
        System.out.println(dtos);
        System.out.println(buildingId);
        BuildingDto buildingDto = new BuildingDto();
        buildingDto.setId(Long.valueOf(buildingId));
        //插入或更新user表
        StringBuilder safetyManagerBuilder = new StringBuilder();
        String safetyDuty = "";
        String safetyManager = "";
        for (BuildingResponsiblePersonDto dto:dtos){
            RequestResult<BuildingResponsiblePersonDto> requestResult = buildingResponsiblePersonService.insert(dto);
            BuildingResponsiblePersonDto requestResultData = requestResult.getData();
            if(dto.getType()==0){
                safetyDuty=requestResultData.getId().toString();
                buildingDto.setSafetyDutyName(requestResultData.getRealName());
                buildingDto.setSafetyDutyPhone(requestResultData.getPhone());
            }else{
                safetyManagerBuilder.append(requestResultData.getId().toString()+",");
            }
        }
        //获得更新后改建筑物下的安全管理人ids
        safetyManagerBuilder.setLength(safetyManagerBuilder.length()-1);
        safetyManager = safetyManagerBuilder.toString();

        //构建BuildingDto对象
        buildingDto.setSafetyDuty(safetyDuty);
        buildingDto.setSafetyManager(safetyManager);
        //更新building表
        System.out.println(buildingDto);
        return  buildingManageService.update(buildingDto);
    }



    //doing----注意可能要新增将图片保存到服务器的方法---ok
    @Override
    public RequestResult updateDetailToFireSafeMassage(BuildingSecurityMassageDto dto) {
        //将安全证书图片上传到服务器

        //更新消防安全数据
        return  buildingSecurityMassageManageService.update(dto);
    }

    //ok
    @Override
    public RequestResult insert(BuildingDto dto) {
        //插入用户表
        BuildingResponsiblePersonDto buildingResponsiblePersonDto = new BuildingResponsiblePersonDto();
        buildingResponsiblePersonDto.setRealName(dto.getSafetyDutyName());
        buildingResponsiblePersonDto.setPhone(dto.getSafetyDutyPhone());
        RequestResult<BuildingResponsiblePersonDto> result = buildingResponsiblePersonService.insert(buildingResponsiblePersonDto);
        System.out.println(result);

        Long id = result.getData().getId();
        dto.setSafetyDuty(id.toString());
        //插入建筑物表

        System.out.println("插入建筑物表");
        RequestResult requestResult = buildingManageService.insert(dto);
        return requestResult;
    }

    //ok
    @Override
    public RequestResult remove(String id) {
        return buildingManageService.remove(id);
    }

    //ok
    @Override
    public RequestResult queryBuildIdAndNameListByFuzzyName(String fuzzyName) {
        return buildingManageService.queryBuildIdAndNameListByFuzzyName(fuzzyName);
    }

    //ok
    @Override
    public RequestResult queryFloorById(String id) {
        return buildingManageService.queryFloorById(id);
    }
}
