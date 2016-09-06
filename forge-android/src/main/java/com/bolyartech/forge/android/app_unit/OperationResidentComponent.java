package com.bolyartech.forge.android.app_unit;

/**
 * Single operation resident component
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
public interface OperationResidentComponent extends ResidentComponent, OperationStateInterface {
    enum OpState {
        IDLE,
        BUSY,
        COMPLETED
    }

    OpState getOpState();
    void switchToState(OpState opState);
    boolean isInOpState(OpState opState);

    interface Listener {
        void onResidentOperationStateChanged();
    }

    OperationStateInterface getActivityInterface();
}
