package com.bolyartech.forge.android.app_unit;

public interface MultiOperationResidentComponent<T extends Enum<T>> extends OperationResidentComponent,
        MultiOprationStateInterface<T> {


    void switchToBusyState(T operation);
    void switchToCompletedStateSuccess();
    void switchToCompletedStateFail();
    void switchToIdleState();

    @SuppressWarnings("SpellCheckingInspection")
    MultiOprationStateInterface getActivityInterface();
}
