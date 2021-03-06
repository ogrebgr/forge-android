package com.bolyartech.forge.android.app_unit.rc_task;

import com.bolyartech.forge.android.app_unit.ResidentComponent;
import com.bolyartech.forge.base.rc_task.RcTask;


public interface RctResidentComponent extends ResidentComponent, TaskExecutionStateful {
    void executeTask(RcTask task);

    RcTask getCurrentTask();

    void abort();

    interface Listener {
        void onResidentTaskExecutionStateChanged();
    }
}
