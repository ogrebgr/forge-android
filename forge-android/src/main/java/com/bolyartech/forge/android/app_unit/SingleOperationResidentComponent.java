package com.bolyartech.forge.android.app_unit;

public interface SingleOperationResidentComponent extends OperationResidentComponent {
    void switchToBusyState();
    void switchToCompletedStateSuccess();
    void switchToCompletedStateFail();
    void switchToIdleState();
}
