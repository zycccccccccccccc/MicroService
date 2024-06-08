package com.bjtu.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("用户名是否存在检查")
@Data
public class UserCheckDTO {

    @ApiModelProperty("用户名")
    @NotBlank
    private String userName;
}
