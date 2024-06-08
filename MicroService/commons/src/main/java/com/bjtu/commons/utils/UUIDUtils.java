package com.bjtu.commons.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.nio.ByteBuffer;
import java.util.Random;


public class UUIDUtils {
    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake();
    private static final Random RANDOM = new Random();

    /**
     * @return long类型的uid
     */
    public static long next() {
        return SNOWFLAKE.nextId();
    }

    /**
     * @return 字符串长度为11的uid
     */
    public static String nextStr() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(next());
        return Base64.encodeUrlSafe(buffer.array());
    }

    /**
     * @param randAppend 随机额外字符串长度
     * @return 字符串长度为 11 + randAppend 的uid
     */
    public static String nextStr(int randAppend) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(next());
        int len = (randAppend * 3 - 1) / 4 + 1;
        byte[] bytes = new byte[len];
        RANDOM.nextBytes(bytes);
        return Base64.encodeUrlSafe(buffer.array()) + Base64.encodeUrlSafe(bytes).substring(0, randAppend);
    }
}
