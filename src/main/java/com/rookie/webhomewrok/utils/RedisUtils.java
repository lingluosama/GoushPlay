package com.rookie.webhomewrok.utils;


import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private Gson gson;

    public void setValue(String key, Object value, Integer hours) {
        redisTemplate.opsForValue().set(key, gson.toJson(value));
        redisTemplate.expire(key, hours, TimeUnit.HOURS);
    }

    public void increment(String key, int value) {
        redisTemplate.opsForValue().increment(key, value);
    }

    public void decrement(String key, int value) {
        redisTemplate.opsForValue().decrement(key, value);
    }

    public <T> T getValue(String key, Class<T> Clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        return gson.fromJson(value.toString(), Clazz);
    }

    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

}
