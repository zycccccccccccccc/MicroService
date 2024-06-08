package com.bjtu.user.service;

import com.bjtu.commons.dto.UserLoginDTO;
import com.bjtu.commons.po.User;

public interface UserService {


    /**
     * 注册业务
     *
     * @param user 参数已经校验
     * @return
     */
    void register(User user);

    /**
     * 登录业务
     *
     * @param userLoginDTO 账号和密码 已经校验
     * @return token令牌
     */
    String login(UserLoginDTO userLoginDTO);
}
