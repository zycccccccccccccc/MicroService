package com.bjtu.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjtu.user.mapper.UserMapper;
import com.bjtu.user.service.UserService;
import com.bjtu.commons.auth.AuthRedisKey;
import com.bjtu.commons.constants.UserConstants;
import com.bjtu.commons.dto.UserLoginDTO;
import com.bjtu.commons.exception.CommonException;
import com.bjtu.commons.po.User;
import com.bjtu.commons.utils.MD5Util;
import com.bjtu.commons.utils.ResultCode;
import com.bjtu.commons.utils.UUIDUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final RedisTemplate<Object, Object> redisTemplate;
    @Value("${auth.token-expire-days}")
    private int tokenExpireDays;

    /**
     * 注册业务
     * 1. 检查账号是否存在
     * 2. 密码加密处理
     * 3. 插入数据库数据
     *
     * @param user 参数已经校验
     * @return
     */
    @Override
    public void register(User user) {
        //1.密码加密加盐
        String newPwd = MD5Util.encode(user.getPassword() + UserConstants.USER_SALT);
        user.setPassword(newPwd);

        //2.插入数据库数据
        int rows = userMapper.insert(user);

        //如果插入失败，只能是因为主键重复了
        if (rows == 0) {
            log.info("注册业务结束，结果:{}", "数据插入失败!注册失败!");
            throw new CommonException(ResultCode.USER_ID_EXISTS);
        }

        log.info("注册业务结束，结果:{}", "注册成功");
    }

    /**
     * 登录业务
     * 1. 密码的加密和加盐处理
     * 2. 账号和密码进行数据库查询.返回一个完整的数据库user对象
     * 3. 判断返回结果
     *
     * @param userLoginDTO 账号和密码 已经校验
     * @return
     */
    @Override
    public String login(UserLoginDTO userLoginDTO) {

        //1.密码处理
        String newPwd = MD5Util.encode(userLoginDTO.getPassword() + UserConstants.USER_SALT);

        //2.数据库查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userLoginDTO.getUserId());
        queryWrapper.eq("password", newPwd);

        User user = userMapper.selectOne(queryWrapper);

        //3.结果处理
        if (user == null) {
            log.info("登录业务结束，结果:{}", "账号密码错误!请重新输入!");
            throw new CommonException(ResultCode.LOGIN_ERROR);
        }

        log.info("登录业务结束，结果:{}", "登录成功!");

        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
        String uid2token = AuthRedisKey.UID_TO_TOKEN + user.getUserId();
        String oldToken = (String) ops.get(uid2token);

        if (oldToken != null) {
            redisTemplate.delete(oldToken);
        }
        String token = UUIDUtils.nextStr(10);
        ops.set(AuthRedisKey.TOKEN_TO_UID+token, user.getUserId(), Duration.ofDays(tokenExpireDays));
        ops.set(uid2token, token, Duration.ofDays(tokenExpireDays));
        return token;
    }
}
