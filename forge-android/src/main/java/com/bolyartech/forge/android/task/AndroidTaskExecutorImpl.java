package com.bolyartech.forge.android.task;

import com.bolyartech.forge.base.task.TaskExecutorImpl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Android specific task executor
 *
 * Implements IdlingResource so it can be used with mockito
 * @param <T> Type of the result
 */
@SuppressWarnings("WeakerAccess")
public class AndroidTaskExecutorImpl<T> extends TaskExecutorImpl<T> implements AndroidTaskExecutor<T> {
    private final List<ResourceCallback> mResourceCallbacks = new CopyOnWriteArrayList<>();



    @Override
    public String getName() {
        return "com.bolyartech.forge.android.task.AndroidTaskExecutorImpl";
    }


    @Override
    public boolean isIdleNow() {
        return getTasksInFlightCount() == 0;
    }


    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mResourceCallbacks.add(callback);
    }


    @Override
    protected void onIdle() {
        super.onIdle();

        for(ResourceCallback c : mResourceCallbacks) {
            c.onTransitionToIdle();
        }
    }
}
