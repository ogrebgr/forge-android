package com.bolyartech.forge.android.app_unit;

import android.support.annotation.Nullable;


/**
 * Defines interface for operation resident component with single operation with side effects: result or error, or both
 *
 * @param <RESULT> type of the result of the operation. Use <code>Void</code> if not used
 * @param <ERROR>  type of the error of the operations. Use <code>Void</code> if not used
 */
@SuppressWarnings({"unused"})
public interface SideEffectOperationResidentComponent<RESULT, ERROR> extends ResidentComponent {
    /**
     * Switches to busy state
     */
    void switchToBusyState();

    /**
     * Switches to ENDED state with success flag on and with result <code>rez</code>
     *
     * @param rez Result of the operation
     */
    void switchToEndedStateSuccess(@Nullable RESULT rez);

    /**
     * Switches to ENDED state with success flag off and with error <code>error</code>
     *
     * @param error Resulting error
     */
    void switchToEndedStateFail(@Nullable ERROR error);


    /**
     * Gets the error of the operation
     *
     * @return Error of the operation
     */
    ERROR getLastError();

    /**
     * Gets the result of the operation
     *
     * @return Result of the operation
     */
    RESULT getLastResult();


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
     * Aborts the current operation and switches to idle state
     */
    void abort();

    /**
     * Convenience alias of {@link #isInBusyState}
     *
     * @return
     */
    boolean isBusy();

    /**
     * @return true if resident component is in {@link OperationResidentComponent.OpState#BUSY}
     */
    boolean isInBusyState();
}