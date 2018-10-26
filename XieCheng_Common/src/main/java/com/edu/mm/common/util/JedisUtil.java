package com.edu.mm.common.util;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@Author feri
 *@Date Created in 2018/10/11 09:07
 */
public class JedisUtil {
    private Lock lock;
    private Jedis jedis;
    private String host;
    private int port;
    private String pass;

    public JedisUtil(String host, int port, String pass) {
        this.host = host;
        this.port = port;
        this.pass = pass;
        //连接池
//        JedisPool jedisPool=new JedisPool(host,port);
//        jedis=jedisPool.getResource();
        jedis=new Jedis(host,port);
        jedis.auth(pass);
        lock=new ReentrantLock();
    }

    //新增
    public synchronized void addStr(String key,String value){
        jedis.set(key,value);
    }
    public void addStrSec(String key,String value,int seconds){
        try {
            lock.lock();
            jedis.set(key, value, null, "EX", seconds);
        }finally {
            lock.unlock();
        }
    }
    public void addList(String key,String... values){
        jedis.rpush(key,values);
    }
    public void addSet(String key,String... values){
        jedis.sadd(key,values);
    }
    public void addZeSet(String key,double score,String value){
        jedis.zadd(key,score,value);
    }
    public void addHash(String key,String field,String value){
        jedis.hset(key,field,value);
    }

    //删除
    public void del(String... keys){
        jedis.del(keys);
    }
    public void delList(String key,int count,String value){
        jedis.lrem(key,count,value);
    }
    public void delSet(String key,String... values){
        jedis.srem(key,values);
    }
    public void delHash(String key,String... fields){ jedis.hdel(key,fields); }
    //查询
    public boolean isExists(String key){
        return jedis.exists(key);
    }

    public boolean isHaveSet(String key,String value){
       return jedis.sismember(key,value);
    }
    public String getStr(String key){
        return jedis.get(key);
    }
    public String getList(String key,int index){
      return jedis.lindex(key,index);
    }
    public long getListLen(String key){
        return jedis.llen(key);
    }
    public List<String> getListAll(String key){
        return jedis.lrange(key,0,getListLen(key)-1);
    }

    public String getHash(String key,String field){
        return jedis.hget(key,field);
    }
    //系统
    public void expire(String key,int seconds){
        jedis.expire(key,seconds);
    }
    public void persist(String key){
        jedis.persist(key);
    }




}
