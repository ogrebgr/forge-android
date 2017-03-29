package com.bolyartech.forge.android.task;

import com.bolyartech.forge.base.exchange.forge.ForgeExchangeResult;
import com.bolyartech.forge.base.misc.TimeProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;


/**
 * Task executor for Forge exchanges
 */
public class ForgeAndroidTaskExecutor extends AndroidTaskExecutorImpl<ForgeExchangeResult> {
    public ForgeAndroidTaskExecutor() {
    }


    public ForgeAndroidTaskExecutor(ExecutorService taskExecutorService, ScheduledExecutorService scheduler) {
        super(taskExecutorService, scheduler);
    }


    public ForgeAndroidTaskExecutor(ExecutorService taskExecutorService, int ttlCheckInterval, int taskTtl, ScheduledExecutorService scheduler, TimeProvider timeProvider) {
        super(taskExecutorService, ttlCheckInterval, taskTtl, scheduler, timeProvider);
    }
}
