package com.bolyartech.forge.android.app_unit;

public interface UnitActivity {
    boolean isFinishing();

    ResidentComponent createResidentComponent();
    void setResidentComponent(ResidentComponent res);
    ResidentComponent getResidentComponent();

    void stateChanged();
}
