package com.bolyartech.forge.android.app_unit;


public interface OperationResidentComponent {
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
