package com.cfireworks.product.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-04-04 17:07
 **/
@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdLe());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(),redisConfig.getPort(),
                redisConfig.getTimeout()*1000, redisConfig.getPassword(), 0);
        return jp;
    }
}
