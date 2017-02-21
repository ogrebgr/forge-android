package com.bolyartech.forge.android.app_unit;

import android.support.annotation.Nullable;


/**
 * Defines interface for operation resident component with single operation with side effects: result or error, or both
 *
 * @param <RESULT> type of the result of the operation. Use <code>Void</code> if not used
 * @param <ERROR>  type of the error of the operations. Use <code>Void</code> if not used
 */
@SuppressWarnings({"unused"})
public interface SideEffectOperationResidentComponent<RESULT, ERROR> extends ResidentComponent, OpStateful, Abortable,
        EndingTests {


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
}