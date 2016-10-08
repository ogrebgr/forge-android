package com.bolyartech.forge.android.app_unit;

/**
 * Operation resident component
 * <p>
 * Uses simple finite state machine with 3 states:
 * <ul>
 * <li>IDLE - when idle and ready to execute operation</li>
 * <li>BUSY - when executing operations is in progress</li>
 * <li>COMPLETED - when operation is completed</li>
 * </ul>
 */
@SuppressWarnings("unused")
public interface OperationResidentComponent extends ResidentComponent {
    /**
     * Returns the operation state
     *
     * @return operation state
     */
    OpState getOpState();

    /**
     * Switches to state <code>opState</code>
     *
     * @param opState operation state
     */
    void switchToState(OpState opState);

    /**
     * Checks if in given state
     *
     * @param opState operation state
     * @return true if state <code>opState</code>
     */
    boolean isInOpState(OpState opState);

    /**
     * Notifies the resident that completed state is observed. Resident should switch to IDLE state.
     */
    void completedStateAcknowledged();

    /**
     * Convenience alias of {@link #completedStateAcknowledged}
     */
    void ack();

    /**
     * Convenience alias of {@link #isCompletedSuccessfully}
     *
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isSuccess();

    /**
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isCompletedSuccessfully();

    /**
     * Convenience alias of {@link #isInIdleState}
     *
     * @return true if resident component is in {@link OperationResidentComponent.OpState#IDLE}
     */
    boolean isIdle();

    /**
     * @return true if resident component is in {@link OperationResidentComponent.OpState#IDLE}
     */
    boolean isInIdleState();

    enum OpState {
        /**
         * Defines idle state, i.e. not working on operation, just waiting
         */
        IDLE,
        /**
         * Defines busy state, i.e. working on operation
         */
        BUSY,
        /**
         * Defines completed state, i.e. operation has completed (and result or error may be available)
         */
        COMPLETED
    }

    /**
     * Listener to be notified when operation state changes
     */
    interface Listener {
        /**
         * Called when resident operation state changed
         */
        void onResidentOperationStateChanged();
    }

}
