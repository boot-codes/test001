//package com.aosica.ai.planting.api.fallback;
//import com.aosica.lot.api.LotApi;
//import com.aosica.lot.dto.LotDto;
//import feign.hystrix.FallbackFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @PackgeName com.aosica.ai.planting.api.fallback
// * @ClassName LotServiceFallBack.java
// * @Description: TODO
// * @Author: yuzp
// * @Date: 2019/8/16 20:25
// * @UpdateUser: yuzp
// * @UpdateDate: 2019/8/16$ 20:25$
// * @UpdateRemark: TODO
// * @Version: 1.0
// */
//
//@Component
//public class LotServiceFallBack implements FallbackFactory<LotApi> {
//
//
//    @Override
//    public LotApi create(Throwable throwable) {
//
//        return new LotApi(){
//            @Override
//            public List<LotDto> getList() {
//                List<LotDto> lotDtoList = new ArrayList<>() ;
//                LotDto lotDto = new LotDto() ;
////                lotDto.setId(System.currentTimeMillis());
////                lotDto.setDeviceName("这是默认值。。。。。。");
//                lotDtoList.add(lotDto) ;
//                return  lotDtoList ;
//            }
//
//
//
//        };
//    }
//
//}