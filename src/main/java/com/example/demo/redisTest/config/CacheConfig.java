package com.example.demo.redisTest.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.reflect.Method;
@Configuration
public class CacheConfig {
    /**
     * 自定义 Cache 的 key 生成器
     */
    @Bean("oneKeyGenerator")
    public KeyGenerator getKeyGenerator (){
        return new KeyGenerator() {
            @Override
            public Object generate(Object obj, Method method, Object... objects) {
                return "KeyGenerator:"+method.getName();
            }
        } ;
    }
}