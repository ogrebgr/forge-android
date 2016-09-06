package com.bolyartech.forge.android.app_unit;

/**
 * Interface exposed by {@link SideEffectOperationResidentComponent} to activity
 * @param <RESULT> Type of the result. Use Void if none
 * @param <ERROR> Type of the error. Use Void if none
 */
@SuppressWarnings("SpellCheckingInspection")
public interface SideEffectStateInterface<RESULT, ERROR> extends OperationStateInterface {
    ERROR getLastError();
    RESULT getLastResult();
}
