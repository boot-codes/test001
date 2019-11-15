package com.aosica.user.api;



import com.aosica.common.bean.RequestResult;
import com.aosica.user.dto.MenuDto;
import com.aosica.user.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @PackgeName com.aosica.base.api
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 9:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class MenuApiService implements MenuServiceApi {

    private Logger logger = LoggerFactory.getLogger(MenuApiService.class);


    @Autowired
    private MenuService menuService;

    @Override
    public RequestResult selectAuthAllMenu(String userId) {
        RequestResult requestResult = null;
        try{
            requestResult = menuService.selectAuthAllMenu(userId);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("菜单{selectAuthAllMenu}接口异常"+e.getMessage());
        }
        return  requestResult;
    }

    @Override
    public RequestResult save(MenuDto menuDto) {
        RequestResult requestResult = null;
        try{
            requestResult = menuService.save(menuDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("菜单{save}接口异常"+e.getMessage());
        }
        return  requestResult;
    }
}
























