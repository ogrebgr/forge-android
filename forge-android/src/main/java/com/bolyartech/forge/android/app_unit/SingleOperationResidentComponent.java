package com.bolyartech.forge.android.app_unit;

/**
 * Single operation resident component
 *
 * Use this class when your resident component has just one operation
 */
@SuppressWarnings({"unused"})
public interface SingleOperationResidentComponent extends OperationResidentComponent {
    /**
     * Switches to busy state
     */
    void switchToBusyState();

    /**
     * Switches to completed state with success flag on
     */
    void switchToCompletedStateSuccess();

    /**
     * Switches to completed state with success flag off
     */
    void switchToCompletedStateFail();

    /**
     * Switches to idle state
     */
    void switchToIdleState();
}
