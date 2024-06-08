package com.bjtu.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("用户登录参数")
@Data
public class UserLoginDTO {

    @ApiModelProperty("用户id")
    @NotBlank
    private String userId;

    @ApiModelProperty("密码")
    @NotBlank
    private String password;
}
