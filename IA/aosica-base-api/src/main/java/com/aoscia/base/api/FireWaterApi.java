package com.aoscia.base.api;

import com.aoscia.base.dto.FireWaterDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("fireWater")
public interface FireWaterApi {
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<FireWaterDto>> selectList(@RequestBody FireWaterDto dto);

    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody FireWaterDto dto);

    @RequestMapping(value = "/selectDetailById", method = RequestMethod.GET)
    RequestResult selectDetailById(@RequestParam(value = "id") String id);

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    RequestResult remove(@RequestParam(value = "id") String id);

}
