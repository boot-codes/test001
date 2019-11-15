package com.aosica.lot.dto;

import com.aosica.common.annotation.SpecialCharacterCheck;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @PackgeName com.aosica.lot.dto
 * @ClassName FireFightingDeviceQueryDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 20:54
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 20:54$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Data
@ApiModel(value = "查询消防设备DTO")
public class FireFightingDeviceQueryDto {

    @ApiModelProperty(value = "分页页数",required = true)
    private int pageNum =0 ;

    @ApiModelProperty(value = "每页显示的条数",required = true)
    private int pageSize=10 ;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "工程id",required = true)
    private String projectId ;

    @ApiModelProperty(value = "系统类型")
    private String systemType;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;


    @SpecialCharacterCheck
    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "安装位置")
    private String installLocation;

    @ApiModelProperty(value = "建筑物id")
    private Integer buildingId;


    @SpecialCharacterCheck
    @ApiModelProperty(value = "建筑物名称")
    private String buildingName;

    @ApiModelProperty(value = "安装楼层")
    private Integer installFloor;

    @ApiModelProperty(value = "关联单位名称")
    private String associatedUnit;

    @SpecialCharacterCheck
    @ApiModelProperty(value = "监管单位名称")
    private String supervisionUnitName;

    @ApiModelProperty(value = "父设备id")
    private Long parentId ;


    @ApiModelProperty(value = "创建人")
    private Long creater;


    @ApiModelProperty(value = "备用字段")
    private String fbk ;


    @ApiModelProperty(value = "状态")
    private Integer statue;


    @ApiModelProperty(value = "查询时间",example = "fbk=month   queryDate=2019-09 ,fbk=year  queryData=2019")
    private String queryDate ;


    public int getPageNum() {
        return pageNum;
    }


    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
            return pageSize;
    }

    /**
     * 只有当大于默认的10条记录时，才会设置
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
//       if(pageSize >10) {
            this.pageSize = pageSize;
//        }
    }
}
