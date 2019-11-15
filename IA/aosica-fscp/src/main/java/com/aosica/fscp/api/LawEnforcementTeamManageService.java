package com.aosica.fscp.api;

import com.aoscia.base.api.LawEnforcementTeamServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface   LawEnforcementTeamManageService extends LawEnforcementTeamServiceApi {

}
