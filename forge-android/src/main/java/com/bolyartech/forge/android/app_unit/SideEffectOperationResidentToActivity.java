package com.bolyartech.forge.android.app_unit;

/**
 * Interface exposed by {@link SideEffectOperationResidentComponent} to activity
 * @param <RESULT> Type of the result. Use Void if none
 * @param <ERROR> Type of the error. Use Void if none
 */
@SuppressWarnings({"unused"})
public interface SideEffectOperationResidentToActivity<RESULT, ERROR> extends OperationResidentToActivity {
    ERROR getLastError();
    RESULT getLastResult();
}
