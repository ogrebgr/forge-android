package com.bolyartech.forge.android.app_unit;

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
     * @return
     */
    boolean isSuccess();
    boolean isCompletedSuccessfully();

    /**
     * Convenience alias of {@link #isInIdleState}
     * @return
     */
    boolean isIdle();
    boolean isInIdleState();

    interface Listener {
        void onResidentOperationStateChanged();
    }
}
