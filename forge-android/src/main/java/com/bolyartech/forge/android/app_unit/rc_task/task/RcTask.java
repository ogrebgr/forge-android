package com.bolyartech.forge.android.app_unit.rc_task.task;


public interface RcTask<T extends RcTaskResult> extends RcTaskToExecutor, RcTaskQuery {
    // Manage
    void cancel();

    // Consume
    T getResult();


    interface Listener {
        void onTaskEnded(RcTask<?> task);
    }
}
