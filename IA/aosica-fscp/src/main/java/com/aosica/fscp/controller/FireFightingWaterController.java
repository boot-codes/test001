package com.aosica.fscp.controller;

/**
 * @program: ai-planting->FireFightingWaterController
 * @description: 消防水源控制类
 * @author: ll
 * @create: 2019-10-31 11:50
 **/
public class FireFightingWaterController {
   /* @Autowired
    private FireFightingWaterManageSevice waterService ;

    @ApiOperation(value = "查询水源列表")
    @ApiImplicitParam(name ="dto" ,value = "查询对象", dataType = "DeviceStatisticsDto")
    @ApiResponse(code = 200,message = "请求成功")
    @RequestMapping(value = "/deviceStatueNumStatistics",  method = RequestMethod.POST)
    @ResponseBody
    RequestResult<List<FightingWaterDto>> selectList(@RequestBody FightingWaterDto dto) {

        String errorMessage = null ;
        try {
            errorMessage = ObjectUtil.checkNotEmpty(dto.getProjectId(), "工程id 不能为空") ;
        }
        catch (Exception e) {
            return  RequestResult.build(500 , errorMessage) ;
        }
        return  this.waterService.selectList(dto) ;
    }*/

}
