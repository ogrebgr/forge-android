package com.bolyartech.forge.android.app_unit;

public interface MultiOperationResidentComponent<T extends Enum<T>> extends OperationResidentComponent,
        MorcActivityInterface<T> {


    void switchToBusyState(T operation);
    void switchToCompletedStateSuccess();
    void switchToCompletedStateFail();
    void switchToIdleState();

    @SuppressWarnings("SpellCheckingInspection")
    MorcActivityInterface getActivityInterface();
}
