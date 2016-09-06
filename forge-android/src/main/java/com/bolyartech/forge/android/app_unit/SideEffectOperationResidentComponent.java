package com.bolyartech.forge.android.app_unit;

@SuppressWarnings({"WeakerAccess", "unused"})
public interface SideEffectOperationResidentComponent<RESULT, ERROR> extends OperationResidentComponent {
    void switchToBusyState();
    void switchToCompletedStateSuccess(RESULT rez);
    void switchToCompletedStateFail(ERROR error);
    void switchToIdleState();
}
