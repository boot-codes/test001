package com.aosica.fscp.api;

import com.aosica.user.api.BuildingResponsiblePersonApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "aosica-user")
public interface BuildingResponsiblePersonManageService extends BuildingResponsiblePersonApi {

}
