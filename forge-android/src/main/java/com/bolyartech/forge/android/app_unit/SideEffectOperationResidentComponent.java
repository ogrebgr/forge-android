package com.bolyartech.forge.android.app_unit;

/**
 * Defines interface for operation resident component with single operation with side effects: result or error, or both
 * @param <RESULT>  type of the result of the operation. Use <code>Void</code> if not used
 * @param <ERROR>  type of the error of the operations. Use <code>Void</code> if not used
 */
@SuppressWarnings({"unused"})
public interface SideEffectOperationResidentComponent<RESULT, ERROR> extends OperationResidentComponent {
    /**
     * Switches to busy state
     */
    void switchToBusyState();

    /**
     * Switches to completed state with success flag on and with result <code>rez</code>
     */
    void switchToCompletedStateSuccess(RESULT rez);

    /**
     * Switches to completed state with success flag off and with error <code>error</code>
     */
    void switchToCompletedStateFail(ERROR error);

    /**
     * Switches to idle state
     */
    void switchToIdleState();
}
