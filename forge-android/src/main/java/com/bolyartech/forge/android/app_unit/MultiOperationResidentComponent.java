package com.bolyartech.forge.android.app_unit;

/**
 * Resident component with multiple operations
 *
 * Define your operations in an enum and provide it as type parameter T
 *
 * @param <T>
 */
public interface MultiOperationResidentComponent<T extends Enum<T>> extends OperationResidentComponent {

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
     * Switches to idle state
     */
    void switchToIdleState();

    /**
     * Returns the current operation T or null if not available
     * @return current operation T
     */
    T getCurrentOperation();
}
