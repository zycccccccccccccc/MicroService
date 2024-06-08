package com.bjtu.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("分页参数")
@Data
public class PageDTO {

    @ApiModelProperty("页码")
    private Integer pageNo = 1;

    @ApiModelProperty("每页显示数量")
    private Integer pageSize = 5;
}
