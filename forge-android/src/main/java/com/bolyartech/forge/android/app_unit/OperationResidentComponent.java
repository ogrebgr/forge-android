package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.base.misc.ForUnitTestsOnly;


/**
 * Operation resident component
 *
 * Uses simple finite state machine with 3 states:
 * <ul>
 *     <li>IDLE - when idle and ready to execute operation</li>
 *     <li>BUSY - when executing operations is in progress</li>
 *     <li>ENDED - when operation is ended</li>
 * </ul>
 *
 */
public interface OperationResidentComponent extends ResidentComponent {
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
     * Notifies the resident that ENDED state is observed. Resident should switch to IDLE state.
     */
    void endedStateAcknowledged();

    /**
     * Convenience alias of {@link #endedStateAcknowledged}
     */
    void ack();

    /**
     * Convenience alias of {@link #isEndedSuccessfully}
     *
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isSuccess();

    /**
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isEndedSuccessfully();

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


    /**
     * Convenience alias of {@link #isInBusyState}
     * @return
     */
    boolean isBusy();

    /**
     * @return true if resident component is in {@link OperationResidentComponent.OpState#BUSY}
     */
    boolean isInBusyState();

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
         * Defines end state, i.e. operation has ended (and result or error might be available)
         */
        ENDED
    }


    /**
     * Switches to busy state
     */
    void switchToBusyState();


    /**
     * Aborts the current operation and switches to idle state
     */
    void abort();


    /**
     * Switches to ENDED state with success flag on
     */
    void switchToEndedStateSuccess();

    /**
     * Switches to ENDED state with success flag off
     */
    void switchToEndedStateFail();


    /**
     * Returns listener
     * @return listener
     */
    Listener getListener();


    /**
     * Listener to be notified when operation state changes
     */
    interface Listener {
        /**
         * Called when resident operation state changed.
         * Listeners (i.e. your activities) must not acquire locks or do lengthy operations in this method. Best
         * practice is to just do <code>runOnUiThread(() -> handleState(getRes().getOpState()));</code>
         */
        void onResidentOperationStateChanged();
    }
}
