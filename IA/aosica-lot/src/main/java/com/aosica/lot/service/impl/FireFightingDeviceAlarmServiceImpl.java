package com.aosica.lot.service.impl;

import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.FireFightingDeviceAlarmDto;
import com.aosica.lot.dto.FireFightingDeviceAlarmQueryDto;
import com.aosica.lot.entity.FireFightingDeviceAlarm;
import com.aosica.lot.mapper.FireFightingDeviceAlarmMapper;
import com.aosica.lot.service.FireFightingDeviceAlarmService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 智慧消防设备service
 * @PackgeName com.aosica.lot.service.impl
 * @ClassName FireFightingDeviceAlarmServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/21 11:07
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/21$ 11:07$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Service
public class FireFightingDeviceAlarmServiceImpl implements FireFightingDeviceAlarmService {


    @Autowired
    private FireFightingDeviceAlarmMapper alarmMapper ;

    /**
     * 添加数据消防报警数据。
     *
     * @param fireFightingDevice
     */
    @Override
    public void save(FireFightingDeviceAlarm fireFightingDevice) throws AosicaServiceSaveException {
        this.alarmMapper.insert(fireFightingDevice) ;
    }


    /**
     * 查询 设备的报警历史记录
     *
     * @param dto
     * @return
     */
    @Override
    public Page<FireFightingDeviceAlarmDto> list(FireFightingDeviceAlarmQueryDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize()) ;
        return this.alarmMapper.list(dto);
    }


}



















