package com.aosica.fscp.api;


import com.aoscia.base.api.FightingWaterApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface FireFightingWaterManageSevice extends FightingWaterApi {


}
