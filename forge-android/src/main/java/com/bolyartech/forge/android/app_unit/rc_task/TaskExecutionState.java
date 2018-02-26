package com.bolyartech.forge.android.app_unit.rc_task;

/**
 * States for stateful operation resident components
 */
public enum TaskExecutionState {
    /**
     * Defines idle state, i.e. not working on operation, just waiting
     */
    IDLE,
    /**
     * Defines busy state, i.e. working on operation
     */
    BUSY,
    /**
     * Defines end state, i.e. operation has ended (and result or error might be available)
     */
    ENDED
}
