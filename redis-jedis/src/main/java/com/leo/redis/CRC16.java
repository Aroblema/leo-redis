package com.leo.redis;

import redis.clients.util.JedisClusterCRC16;

/**
 * @author leo
 * @create 2020-05-03 20:11
 *
 * redis分片算法CRC16
 * 槽位：16384 slots
 */
public class CRC16 {

    public static void main(String[] args) {
        String str = "name1";
        System.out.println(JedisClusterCRC16.getCRC16(str) % 16384);
        // redis设计键，使其映射至同一个slot
        System.out.println(JedisClusterCRC16.getSlot("{user1}:id"));
        System.out.println(JedisClusterCRC16.getSlot("{user1}:name"));
    }

}
