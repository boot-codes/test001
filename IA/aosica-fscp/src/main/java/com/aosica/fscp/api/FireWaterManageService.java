package com.aosica.fscp.api;

import com.aoscia.base.api.FireWaterApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface FireWaterManageService extends FireWaterApi {

}
