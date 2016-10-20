package com.bolyartech.forge.android.app_unit;

public interface MultiOperationResidentComponent<T extends Enum<T>> extends ResidentComponent {
    /**
     * Switches to busy state and sets current operation to <code>operation</code>
     * @param operation Operation enum value
     */
    void switchToBusyState(T operation);

    /**
     * Switches to completed state with success flag on
     */
    void switchToCompletedStateSuccess();

    /**
     * Switches to completed state with success flag off
     */
    void switchToCompletedStateFail();


    /**
     * Aborts the current operation and switches to idle state
     */
    void abort();


    /**
     * Returns the current operation T or null if not available
     * @return current operation T
     */
    T getCurrentOperation();

    /**
     * Returns the operation state
     *
     * @return operation state
     */
    OperationResidentComponent.OpState getOpState();

    /**
     * Checks if in given state
     *
     * @param opState operation state
     * @return true if state <code>opState</code>
     */
    boolean isInOpState(OperationResidentComponent.OpState opState);

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
}
