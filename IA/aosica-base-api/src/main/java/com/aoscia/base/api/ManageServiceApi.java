package com.aoscia.base.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.*;

public interface ManageServiceApi<T> {

    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<T>> selectList(@RequestBody T dto);

    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    RequestResultPage<Page<T>> saveAndUpdate(@RequestBody T dto);


    @RequestMapping(value = "/selectDetailById", method = RequestMethod.GET)
    RequestResult<T> selectDetailById(@RequestParam(value = "id") String id);


    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    RequestResult remove(@RequestParam(value = "id") String id);

}
