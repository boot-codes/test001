package com.aosica.fscp.api;

import com.aoscia.base.api.FireLedgerServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "aosica-base")
public interface FireLedgerManageService extends FireLedgerServiceApi {


}
