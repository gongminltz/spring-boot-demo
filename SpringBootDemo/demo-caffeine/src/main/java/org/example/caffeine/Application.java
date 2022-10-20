package org.example.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import org.example.caffeine.util.CacheUtils;
import org.example.caffeine.util.LogUtils;

/**
 * 启动类
 *
 * @author gongmin
 * @date 2022/10/14 11:21
 */
public class Application {
    public static void main(String[] args) {
        LogUtils.info("<main> start");

        cacheTest();
    }

    /**
     * Caffeine获取指定key的value值，如果不存在，将会增加该键值对
     */
    private static void cacheTest() {
        Cache<String, Object> cache = CacheUtils.getCache();
        String data = (String) cache.get("name", (k) -> {
            return "gongmin";
        });

        LogUtils.info("<cacheTest> the value of key 'name' is " + data);
    }
}
