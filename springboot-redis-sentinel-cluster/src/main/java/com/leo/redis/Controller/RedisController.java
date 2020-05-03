package com.leo.redis.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leo
 * @create 2020-05-04 1:15
 */
@RestController
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test_Cluster")
    public void testCluster() {
        int i = 1;
        while (true) {
            try {
                stringRedisTemplate.opsForValue().set("cluster" + i, i + "");
                logger.info("设置key：" + "cluster" + i);
                i++;
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.error("错误：" + e);
            }
        }
    }

}
