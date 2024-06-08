package com.bjtu.user.controller;

import com.bjtu.user.service.UserService;
import com.bjtu.commons.dto.UserLoginDTO;
import com.bjtu.commons.po.User;
import com.bjtu.commons.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Api(tags = "用户登录注册")
@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param user   传入账号密码
     * @return
     */

    @ApiOperation("用户注册")
    @PostMapping("register")
    public Result<Void> register(@RequestBody @Valid User user) {
        userService.register(user);
        return Result.success();
    }

    /**
     * 用户登录接口
     *
     * @param userLoginDTO 传入账号密码
     * @return token令牌
     */

    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        String token = userService.login(userLoginDTO);
        return Result.success(token);
    }
}
