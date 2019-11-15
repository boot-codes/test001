package com.aoscia.base.api;

import com.aoscia.base.dto.FireLedgerDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("fireLedger")
public interface FireLedgerServiceApi {
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<FireLedgerDto>> selectList(@RequestBody FireLedgerDto dto);

    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResult saveAndUpdate(@RequestBody FireLedgerDto dto);

    @RequestMapping(value = "/selectDetailById", method = RequestMethod.GET)
    RequestResult selectDetailById(@RequestParam(value = "id") String id);

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    RequestResult remove(@RequestParam(value = "id") String id);

}
