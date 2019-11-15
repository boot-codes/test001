package com.aosica.fscp.api;

import com.aoscia.base.api.BuildingSecurityMassageServiceApi;
import org.springframework.cloud.openfeign.FeignClient;


 @FeignClient(value = "aosica-base")
 public interface BuildingSecurityMassageManageService extends BuildingSecurityMassageServiceApi {

 }
