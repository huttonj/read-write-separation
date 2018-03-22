package main.java.com.mhc.util;

import com.chevrolet.core.template.CacheTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by maihe on 2017/5/24.
 */
public class ThreadPoolUtils {
    //线程池维护线程的最少数量
    public static final int CORE_POOL_SIZE= 4;

    private static ExecutorService executor;

    public static final Object LOCK = new Object();

    public static ExecutorService getThreadPool(){
       return CacheTemplate.getCache(LOCK,new CacheTemplate.CacheBuilder<ExecutorService>() {
            @Override
            public ExecutorService getCache() {
                return ThreadPoolUtils.executor;
            }

            @Override
            public ExecutorService init() {
                ThreadPoolUtils.init();
                return ThreadPoolUtils.executor;
            }
        });
    }

    private static void init(){
        executor = Executors.newFixedThreadPool(CORE_POOL_SIZE);
    }
}
