package com.bjtu.commons.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@TableName("user")
@ApiModel("用户")
@Data
public class User implements Serializable {

    public static final Long serialVersionUID = 1L;

    @ApiModelProperty("user id")
    @TableId(type = IdType.AUTO)
    @NotNull
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank
    private String password;

}
