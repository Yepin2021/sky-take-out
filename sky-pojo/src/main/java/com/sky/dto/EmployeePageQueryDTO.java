package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeePageQueryDTO implements Serializable {

    //员工姓名
    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("页码")
    //页码
    private int page;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private int pageSize;

}
