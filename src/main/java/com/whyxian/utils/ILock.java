package com.whyxian.utils;

/**
 * @author whyxian
 * @version 1.0
 * @description 分布式锁接口
 * @date 2023-02-07 15:58
 */
public interface ILock {

    /**
     * 尝试获取锁
     * @param timeoutSec 锁持有的超时时间，过期后自动释放
     * @return true代表获取锁成功; false代表获取锁失败
     */
    boolean tryLock(long timeoutSec);

    /**
     * 释放锁
     */
    void unlock();

}
