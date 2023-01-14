package com.achilles.themis.domain.policy.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPool {

    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 200,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.DiscardPolicy());

    public static void addTask(Runnable command) {
        threadPool.execute(command);
    }

}
