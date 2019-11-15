package com.aosica.agriculture.api;


import com.aosica.lot.api.AgricultureDeviceApi;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * 智慧农业设备
 */
@FeignClient("aosica-lot")
public interface AgricultureDeviceService extends AgricultureDeviceApi {

}
