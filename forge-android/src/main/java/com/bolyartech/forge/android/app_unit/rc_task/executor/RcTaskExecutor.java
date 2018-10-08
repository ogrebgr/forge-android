package com.bolyartech.forge.android.app_unit.rc_task.executor;

import android.support.annotation.NonNull;

import com.bolyartech.forge.base.rc_task.RcTaskToExecutor;


public interface RcTaskExecutor {
    void execute(@NonNull Listener listener, @NonNull RcTaskToExecutor task);

    interface Listener {
        void onTaskEnded(@NonNull RcTaskToExecutor task);
    }
}
