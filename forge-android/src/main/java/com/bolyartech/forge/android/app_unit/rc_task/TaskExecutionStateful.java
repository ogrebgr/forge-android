package com.bolyartech.forge.android.app_unit.rc_task;



public interface TaskExecutionStateful {
    /**
     * Returns the operation state
     *
     * @return operation state
     */
    TaskExecutionState getTaskExecutionState();

    boolean isInTaskExecutionState(TaskExecutionState state);


    boolean isIdle();


    boolean isInIdleState();


    /**
     * Convenience alias of {@link #isInBusyState}
     *
     * @return true if busy, false otherwise
     */
    boolean isBusy();

    boolean isInBusyState();

    /**
     * Notifies the resident that ENDED state is observed. Resident should switch to IDLE state.
     */
    void endedStateAcknowledged();

    /**
     * Convenience alias of {@link #endedStateAcknowledged}
     */
    void ack();
}
