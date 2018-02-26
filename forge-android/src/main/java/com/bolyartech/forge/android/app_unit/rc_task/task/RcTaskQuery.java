package com.bolyartech.forge.android.app_unit.rc_task.task;

public interface RcTaskQuery {
    int getId();
    boolean isEnded();
    boolean isCancelled();
    boolean isSuccess();
    boolean isFailure();
}
