package com.bolyartech.forge.android.app_unit.rc_task;


import android.support.annotation.NonNull;

import com.bolyartech.forge.android.app_unit.rc_task.executor.RcTaskExecutor;
import com.bolyartech.forge.base.rc_task.RcTaskToExecutor;


public class RctResidentComponentAdapter extends AbstractRctResidentComponent {
    public RctResidentComponentAdapter(RcTaskExecutor taskExecutor) {
        super(taskExecutor);
    }


    @Override
    protected void onTaskPostExecute(@NonNull RcTaskToExecutor endedTask) {
        // empty on purpose
    }
}
