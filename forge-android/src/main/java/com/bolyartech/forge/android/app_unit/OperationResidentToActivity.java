package com.bolyartech.forge.android.app_unit;


/**
 * Interface exposed by OperationResidentComponent to activity
 */
@SuppressWarnings("unused")
public interface OperationResidentToActivity extends ResidentToActivity {
    /**
     * Return operation state
     * @return operation state
     */
    OperationResidentComponent.OpState getOpState();

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
     * @return true if resident component is in {@link OperationResidentComponent.OpState#IDLE}
     */
    boolean isIdle();

    /**
     * @return true if resident component is in {@link OperationResidentComponent.OpState#IDLE}
     */
    boolean isInIdleState();

}
