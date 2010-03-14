/*
 * SynchronizationMBeanImpl.java
 *
 * Created on March 2, 2010, 8:57 PM
 */

package com.rubenlaguna.en4j.sync;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Class SynchronizationMBeanImpl
 *
 * @author Ruben Laguna <ruben.laguna@gmail.com>
 */
public class SynchronizationMBeanImpl implements SynchronizationMBeanImplMBean {
    private ThreadPoolExecutor threadPoolExecutor=null;
    private int auth = 0;
    
    public SynchronizationMBeanImpl(){
    }

    /**
     * Get number of connection thread
     */
    public int getConnectionPoolThreads() {
        if (null==threadPoolExecutor){
            return 0;
        }
        return threadPoolExecutor.getPoolSize();
    }

    void setThreadPoolExecutor(ThreadPoolExecutor RP) {
        this.threadPoolExecutor = RP;
    }

    /**
     * Get number of synch download tasks in the queue
     */
    public int getQueue() {
        return threadPoolExecutor.getQueue().size();
    }

    public long getTasks() {
        return threadPoolExecutor.getTaskCount();
    }

    public int getActiveThreads() {
        return threadPoolExecutor.getActiveCount();
    }
    public int getPoolSize() {
        return threadPoolExecutor.getPoolSize();
    }

    public synchronized void  incrementReauthCounter() {
        auth++;
    }

    public int getNumberOfAuths() {
        return auth;
    }

}

