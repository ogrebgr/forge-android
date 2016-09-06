package com.bolyartech.forge.android.app_unit;

/**
 * Interface exposed by MultiOperationResidentComponent to activity
 * @param <T>
 */
@SuppressWarnings("SpellCheckingInspection")
public interface MultiOprationStateInterface<T> extends OperationStateInterface {
    T getCurrentOperation();
}