package com.bolyartech.forge.android.app_unit.rc_task.executor;

import android.support.annotation.NonNull;

import com.bolyartech.forge.base.rc_task.RcTaskToExecutor;


/**
 * Executes the task on the callers thread. This class is meant to be used directly only in unit tests.
 *
 */
public class DirectRcTaskExecutor implements RcTaskExecutor {
    @Override
    public void execute(@NonNull Listener listener, @NonNull RcTaskToExecutor task) {
        task.execute();
        if (!task.isCancelled()) {
            if (!task.isEnded()) {
                throw new IllegalStateException("Task forgot to call setTaskResult() at its end");
            }

            listener.onTaskEnded(task);
        }
    }
}
