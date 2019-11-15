package com.aosica.agriculture.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @PackgeName com.aosica.ai.planting.api
 * @ClassName PlantingApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/14 19:08
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/14$ 19:08$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RequestMapping("/planting")
public interface PlantingApi {

    @GetMapping("/list")
    List getPlantingList() ;
}
