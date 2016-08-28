package com.bolyartech.forge.android.app_unit;

@SuppressWarnings({"WeakerAccess", "unused"})
public interface SideEffectOperationResidentComponent<RESULT, ERROR> extends OperationResidentComponent {
    ERROR getLastError();
    RESULT getLastResult();
}
