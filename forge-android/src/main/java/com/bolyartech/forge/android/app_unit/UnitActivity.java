package com.bolyartech.forge.android.app_unit;

public interface UnitActivity<T extends ResidentComponent> {
    boolean isFinishing();

    T createResidentComponent();
    void setResidentComponent(T res);
    T getResidentComponent();

    void stateChanged();
}
