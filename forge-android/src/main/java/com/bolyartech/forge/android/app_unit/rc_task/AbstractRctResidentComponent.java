package com.bolyartech.forge.android.app_unit.rc_task;

import android.support.annotation.NonNull;

import com.bolyartech.forge.android.app_unit.ResidentComponentAdapter;
import com.bolyartech.forge.android.app_unit.UnitActivity;
import com.bolyartech.forge.android.app_unit.rc_task.executor.RcTaskExecutor;
import com.bolyartech.forge.base.rc_task.RcTask;
import com.bolyartech.forge.base.rc_task.RcTaskToExecutor;

import org.slf4j.LoggerFactory;


abstract public class AbstractRctResidentComponent extends ResidentComponentAdapter
        implements RctResidentComponent,
        RcTaskExecutor.Listener {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RcTaskExecutor taskExecutor;

    private TaskExecutionState taskExecutionState = TaskExecutionState.IDLE;

    private RctResidentComponent.Listener listener;

    private RcTask currentTask;


    public AbstractRctResidentComponent(RcTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }


    @Override
    public synchronized void executeTask(RcTask task) {
        if (!isIdle()) {
            logger.error("executeTask called when not in IDLE. No execution will take place");
            return;
        }

        if (listener == null) {
            logger.error("Activity is not yet resumed. It is not idea to start a task before activity is resumed because you may not get notified when the task ends. Use isJustCreated() in onResume() to check if activity is just created.");
        }

        if (task.isEnded() || task.isCancelled()) {
            throw new IllegalStateException("Cannot execute a task twice. Create new instance.");
        }
        currentTask = task;
        switchToState(TaskExecutionState.BUSY);
        taskExecutor.execute(this, task);
    }


    @Override
    public RcTask getCurrentTask() {
        return currentTask;
    }


    @Override
    public synchronized void abort() {
        if (currentTask != null) {
            currentTask.cancel();
            currentTask = null;
            switchToState(TaskExecutionState.IDLE);
        } else {
            logger.warn("abort() called when no task is executing");
        }
    }


    @Override
    public synchronized TaskExecutionState getTaskExecutionState() {
        return taskExecutionState;
    }


    @Override
    public boolean isInTaskExecutionState(TaskExecutionState state) {
        return taskExecutionState == state;
    }


    @Override
    public boolean isIdle() {
        return isInIdleState();
    }


    @Override
    public boolean isInIdleState() {
        return getTaskExecutionState() == TaskExecutionState.IDLE;
    }


    @Override
    public boolean isBusy() {
        return isInBusyState();
    }


    @Override
    public boolean isInBusyState() {
        return getTaskExecutionState() == TaskExecutionState.BUSY;
    }


    @Override
    public synchronized void endedStateAcknowledged() {
        if (getTaskExecutionState() == TaskExecutionState.ENDED) {
            currentTask = null;
            switchToState(TaskExecutionState.IDLE);
        } else {
            logger.error("{} Not in ENDED state when calling endedStateAcknowledged() but in {}", this.getClass().getSimpleName(),
                    getTaskExecutionState());
        }
    }


    @Override
    public void ack() {
        endedStateAcknowledged();
    }


    abstract protected void onTaskPostExecute(@NonNull RcTaskToExecutor endedTask);


    @Override
    public void onTaskEnded(@NonNull RcTaskToExecutor endedTask) {
        onTaskPostExecute(endedTask);
        switchToState(TaskExecutionState.ENDED);
    }


    private synchronized void switchToState(TaskExecutionState opState) {
        if (taskExecutionState != opState) {
            taskExecutionState = opState;
            notifyStateChanged();
        } else {
            logger.error("switchToState called but already in state {}", opState);
        }
    }


    private synchronized void notifyStateChanged() {
        if (listener != null) {
            listener.onResidentTaskExecutionStateChanged();
        }
    }


    @Override
    public synchronized void onActivityResumed(UnitActivity activity) {
        super.onActivityResumed(activity);
        if (activity instanceof RctResidentComponent.Listener) {
            listener = (RctResidentComponent.Listener) activity;
        } else {
            logger.warn("This resident is attached to activity that does not implement " +
                    "RctResidentComponent.Listener");
        }
    }


    @Override
    public synchronized void onActivityPaused() {
        super.onActivityPaused();
        listener = null;
    }

}
