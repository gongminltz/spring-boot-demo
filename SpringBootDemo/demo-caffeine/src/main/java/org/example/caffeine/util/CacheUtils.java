package org.example.caffeine.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 *
 * @author gongmin
 * @date 2022/10/20 9:09
 */
public class CacheUtils {
    /**
     * 缓存过期时间，单位为分钟
     */
    private static final long EXPIRE_AFTER_WRITE = 5;

    /**
     * 缓存初始容量
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * 缓存最大条数
     */
    private static final int MAX_SIZE = 1000;

    private static final Cache<String, Object> cache;

    static {
        cache = Caffeine.newBuilder()
                .expireAfterWrite(EXPIRE_AFTER_WRITE, TimeUnit.MINUTES)
                .initialCapacity(INITIAL_CAPACITY)
                .maximumSize(MAX_SIZE)
                .build();
    }

    /**
     * 获取缓存示例
     *
     * @return 返回缓存示例
     */
    public static Cache<String, Object> getCache() {
        return cache;
    }
}
