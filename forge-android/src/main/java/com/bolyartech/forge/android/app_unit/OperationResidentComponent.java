package com.bolyartech.forge.android.app_unit;

/**
 * Operation resident component
 *
 * Uses simple finite state machine with 3 states:
 * <ul>
 *     <li>IDLE - when idle and ready to execute operation</li>
 *     <li>BUSY - when executing operations is in progress</li>
 *     <li>COMPLETED - when operation is completed</li>
 * </ul>
 *
 */
@SuppressWarnings("unused")
public interface OperationResidentComponent extends ResidentComponent, OperationResidentToActivity {
    enum OpState {
        IDLE,
        BUSY,
        COMPLETED
    }

    /**
     * Returns the operation state
     * @return operation state
     */
    OpState getOpState();

    /**
     * Switches to state <code>opState</code>
     * @param opState operation state
     */
    void switchToState(OpState opState);

    /**
     * Checks if in given state
     * @param opState operation state
     * @return true if state <code>opState</code>
     */
    boolean isInOpState(OpState opState);

    /**
     * Listener to be notified when operation state changes
     */
    interface Listener {
        void onResidentOperationStateChanged();
    }

    /**
     * Returns the resident to activity interface
     * @return resident to activity interface
     */
    OperationResidentToActivity getResidentToActivity();
}
