package com.aosica.lot.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.util.DateUtil;
import com.aosica.lot.dto.*;
import com.aosica.lot.service.FireFightingDeviceAlarmService;
import com.aosica.lot.service.FireFightingDeviceService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 【智慧消防】
 *
 * 消防设备管理模块 api
 * @PackgeName com.aosica.lot.api
 * @ClassName FireFightingDeviceServiceApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/23 17:03
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/23$ 17:03$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class FireFightingDeviceServiceApi implements FireFightingDeviceApi {


    private final static String PERCENTAGE = "%" ;

    private final static DecimalFormat decimalFormat=new DecimalFormat("0.000");



    @Autowired
    private FireFightingDeviceService fireFightingDeviceService ;

    @Autowired
    private FireFightingDeviceAlarmService alarmService ;


    /**
     * 【建筑物视角 / 设备视觉】 统计设备数量。
     * 按项目工程统计，统计某个工程下，设备系统的数据，设备的总数量，不正常的设备数量
     *
     * @param
     */
    @Override
    public RequestResultPage<Page<DeviceSystemTypeNumStatisticsDTO>> deviceStatueNumByProjectStatistics(DeviceStatisticsDto dto) {
        try {
            Page<DeviceSystemTypeNumStatisticsDTO> page = this.fireFightingDeviceService.deviceStatueNumByProjectStatistics(dto);
            return  RequestResultPage.buildOK(page) ;
        }
        catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return RequestResultPage.buildFail() ;
        }
    }

    /**
     * 【设备视觉】下的子系统，设备数量统计：
     * 火灾自动报警系统，室内水压监控系统，可燃气体云传输系统，电气火灾监控系统，视频监控系统。子系统的设备数量统计
     *
     * @param dto
     * @return
     */
    @Override
    public RequestResultPage<Page<DeviceSystemTypeDto>> getPageList(FireFightingDeviceQueryDto dto) {

        try {
            Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }


    /**
     * 设备列表查询
     * @param dto
     * @return
     */
    @Override
    public RequestResult<List<DeviceSystemTypeDto>> getList(FireFightingDeviceQueryDto dto) {

        try {
            Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(dto);
            return  RequestResult.buildOkData(page.getResult()) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResult.buildFail() ;
        }
    }

    /**
     * 根据查询对象，查询数据
     *
     * @param dto
     * @return
     */
//    @Override
//    public Page<DeviceSystemTypeDto> getListByCondition(FireFightingDeviceQueryDto dto)  {
//
//        try {
//            Page<DeviceSystemTypeDto> page = this.fireFightingDeviceService.getListByCondition(dto);
//            return  page ;
//        }
//        catch (AosicaServiceQueryException e) {
//            e.printStackTrace();
//            //return  RequestResult.buildFail() ;
//            return  null ;
//        }
//    }


    /******************************************** 物联监控设备统计 *******************************************************/

    /**
     * 1、设备实时运行情况
     *
     * @return
     */
    @Override
    public RequestResult<HashMap<Integer , DeviceStatueDto>> deviceStatueCount(FireFightingDeviceQueryDto deviceQueryDto) {

        // 1:正常，2:误报，3:火警，4：未确认火警 ，5:故障,6:失联
        HashMap<Integer , DeviceStatueDto>  hashMap = new HashMap<Integer , DeviceStatueDto>() {{
                put(1, new DeviceStatueDto());
                put(2, new DeviceStatueDto());
                put(3, new DeviceStatueDto());
                put(4, new DeviceStatueDto());
                put(5, new DeviceStatueDto());
                put(6, new DeviceStatueDto());
            }};

        try {
            List<DeviceStatueDto> deviceStatueList = this.fireFightingDeviceService.deviceStatueCount(deviceQueryDto);
            int sum = deviceStatueList.stream().mapToInt(DeviceStatueDto::getNum).sum();
            deviceStatueList.stream().forEach(dto->{
                float percentage =  (float)dto.getNum()/sum *100 ;
                String format = decimalFormat.format(percentage);
                dto.setPercentage(format+PERCENTAGE);
                //int deviceStatue = dto.getDeviceStatue();
            });

            for(int n=0 ;n<deviceStatueList.size() ;n++) {
                DeviceStatueDto deviceStatueDto = deviceStatueList.get(n);
                int status = deviceStatueDto.getDeviceStatue() ;
                if( hashMap.containsKey(status)) {
//                    DeviceStatueDto statueDto = hashMap.get(status);
//                    statueDto = deviceStatueDto ;
                    hashMap.put(status,deviceStatueDto) ;
                }
            }

            return RequestResult.buildOkData(hashMap) ;
        }
        catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResult.buildFail() ;
        }
    }

    /**
     * 异常设备统计
     *
     * @param deviceQueryDto@return
     */
    @Override
    public RequestResult<List<DeviceStatueDto>> deviceStatueCountByMonthOrYear(FireFightingDeviceQueryDto deviceQueryDto) {

        String startDate = null ;
        String endDate = null ;
        List<DeviceStatueDto> deviceStatueList = null ;

        String queryDate = deviceQueryDto.getQueryDate();
        String fbk = deviceQueryDto.getFbk();
        if("year".equals(fbk)) {
            // 如果按年统计
            startDate = queryDate+"-01-01" ;
            endDate = queryDate+"-12-31" ;
        }
        else {
            // 按月统计 (默认)
            startDate = queryDate+"-01" ;
            endDate = DateUtil.getNextMonthStr(queryDate)+"-01";
        }

        try {
            deviceStatueList = this.fireFightingDeviceService.deviceStatueCountByMonthOrYear(deviceQueryDto, startDate, endDate,fbk);

            int sum =0 ;
            IntStream intStream = null ;
            if ((intStream = deviceStatueList.stream().mapToInt(DeviceStatueDto::getNum)) != null) {
                sum = intStream.sum();
            }

            final int deviceNum = sum ;
            deviceStatueList.stream().forEach(dto->{
                float percentage =  (float)dto.getNum()/deviceNum *100 ;
                String format = decimalFormat.format(percentage);
                dto.setPercentage(format+PERCENTAGE);
            });
            return RequestResult.buildOkData(deviceStatueList) ;
        }
        catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return RequestResult.buildFail() ;
        }

    }



    /**
     * 设备异常报警记录 查询
     *
     * @return
     */
    @Override
    public RequestResultPage<Page<FireFightingDeviceAlarmDto>> deviceAbnormalRecord(FireFightingDeviceAlarmQueryDto alarmQueryDto) {

        Page<FireFightingDeviceAlarmDto> page = null;
        try {
            page = this.alarmService.list(alarmQueryDto);
           return RequestResultPage.buildOK(page) ;
        }
        catch (Exception e) {
            e.printStackTrace();
            return RequestResultPage.buildFail() ;
        }
    }

    /**
     * 根据建筑物id   获取该建筑物里的系统类型。
     *
     * @param projectId
     * @param buildingId
     * @return
     */
    @Override
    public RequestResult<List<SystemTypeDTO>> getSystemTypeByBuildId(@NotNull String projectId, @NotNull Long buildingId) {


        List<SystemTypeDTO> list = this.fireFightingDeviceService.getSystemTypeByBuildId(projectId, buildingId);
        if(list != null && list.size() >0) {
            return  RequestResult.buildOkData(list) ;
        }
        return RequestResult.buildOK() ;
    }


}
