package com.bolyartech.forge.android.app_unit;

public interface OperationResidentComponent extends ResidentComponent {
    enum OperationState {
        IDLE,
        BUSY,
        COMPLETED
    }

    OperationState getOperationState();
    void completedStateAcknowledged();
    boolean isInOperationState(OperationState state);


    interface Listener {
        void onResidentOperationStateChanged();
    }
}
