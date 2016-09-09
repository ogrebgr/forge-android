package com.bolyartech.forge.android.app_unit;

/**
 * Interface exposed by MultiOperationResidentComponent to an activity
 * @param <T>
 */
@SuppressWarnings("SpellCheckingInspection")
public interface MultiOperationResidentToActivity<T> extends OperationResidentToActivity {
    /**
     * Returns the current operation T or null if not available
     * @return current operation T
     */
    T getCurrentOperation();
}