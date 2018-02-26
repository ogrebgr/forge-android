package com.bolyartech.forge.android.app_unit.rc_task.executor;

import android.support.annotation.NonNull;

import com.bolyartech.forge.android.app_unit.rc_task.task.RcTaskToExecutor;

import javax.inject.Inject;


/**
 * Each call to execute() creates new Thread
 */
public class ThreadRcTaskExecutor implements RcTaskExecutor {
    private final DirectRcTaskExecutor directRcTaskExecutor = new DirectRcTaskExecutor();

    @Inject
    public ThreadRcTaskExecutor() {

    }


    @Override
    public synchronized void execute(@NonNull Listener listener, @NonNull RcTaskToExecutor task) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                directRcTaskExecutor.execute(listener, task);
            }
        });

        t.start();
    }
}
