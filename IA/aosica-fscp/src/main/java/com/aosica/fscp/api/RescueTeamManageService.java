package com.aosica.fscp.api;

import com.aoscia.base.api.RescueTeamServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface RescueTeamManageService extends RescueTeamServiceApi {
}
