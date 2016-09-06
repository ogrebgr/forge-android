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
public interface OperationResidentComponent extends ResidentComponent {
    enum OpState {
        IDLE,
        BUSY,
        COMPLETED
    }

    OpState getOpState();
    boolean isInOpState(OpState opState);
    void completedStateAcknowledged();

    /**
     * Convenience alias of {@link #completedStateAcknowledged}
     */
    void ack();


    /**
     * Convenience alias of {@link #isCompletedSuccessfully}
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isSuccess();

    /**
     *
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isCompletedSuccessfully();

    /**
     * Convenience alias of {@link #isInIdleState}
     * @return true if resident component is in {@link OpState#IDLE}
     */
    boolean isIdle();

    /**
     * @return true if resident component is in {@link OpState#IDLE}
     */
    boolean isInIdleState();

    interface Listener {
        void onResidentOperationStateChanged();
    }
}
