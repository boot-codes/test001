package com.aosica.fscp.api;

import com.aosica.lot.api.FireFightingDeviceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @PackgeName com.aosica.fscp.api
 * @ClassName DeviceService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/14 16:32
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/14$ 16:32$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@FeignClient(value = "aosica-lot")
public interface FireFightingDeviceService extends FireFightingDeviceApi {


}
