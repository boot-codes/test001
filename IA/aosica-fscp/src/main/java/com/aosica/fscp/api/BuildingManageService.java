package com.aosica.fscp.api;

import com.aoscia.base.api.BuildingServiceApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "aosica-base")
public interface BuildingManageService extends BuildingServiceApi {
}
