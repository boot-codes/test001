package com.aosica.lot.service;

import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.FireFightingDeviceAlarmDto;
import com.aosica.lot.dto.FireFightingDeviceAlarmQueryDto;
import com.aosica.lot.entity.FireFightingDeviceAlarm;
import com.github.pagehelper.Page;


/**
 * 消防设备异常报警记录service
 * @PackgeName com.aosica.lot.service
 * @ClassName FireFightingDeviceAlarmService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/21 10:57
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/21$ 10:57$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface FireFightingDeviceAlarmService {


    /**
     * 添加数据
     * @param fireFightingDeviceAlarm
     */
    void save(FireFightingDeviceAlarm fireFightingDeviceAlarm) throws AosicaServiceSaveException;


    /**
     * 查询 设备的报警历史记录
     * @param dto
     * @return
     */
    Page<FireFightingDeviceAlarmDto>  list(FireFightingDeviceAlarmQueryDto dto) ;


}
