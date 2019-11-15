package com.aosica.fscp.api;

import com.aoscia.base.api.FireHydrantServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface FireHydrantManageService extends FireHydrantServiceApi {
}
