package com.bolyartech.forge.android.app_unit;

/**
 * Interface exposed by MultiOperationResidentComponent to activity
 * @param <T>
 */
@SuppressWarnings("SpellCheckingInspection")
public interface MultiOperationResidentToActivity<T> extends OperationResidentToActivity {
    T getCurrentOperation();
}