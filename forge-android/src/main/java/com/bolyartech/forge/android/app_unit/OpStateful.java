package com.bolyartech.forge.android.app_unit;

/**
 * @deprecated Please use the new rc_task functionality {@link com.bolyartech.forge.android.app_unit.rc_task.TaskExecutionStateful}
 */
public interface OpStateful {
    /**
     * Returns the operation state
     *
     * @return operation state
     */
    OpState getOpState();

    /**
     * Checks if in given state
     *
     * @param opState operation state
     * @return true if state <code>opState</code>
     */
    boolean isInOpState(OpState opState);


    /**
     * Convenience alias of {@link #isInIdleState}
     *
     * @return true if resident component is in {@link OpState#IDLE}
     */
    boolean isIdle();


    /**
     * @return true if resident component is in {@link OpState#IDLE}
     */
    boolean isInIdleState();


    /**
     * Convenience alias of {@link #isInBusyState}
     *
     * @return true if busy, false otherwise
     */
    boolean isBusy();

    /**
     * @return true if resident component is in {@link OpState#BUSY}
     */
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
