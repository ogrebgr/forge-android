package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


public interface UnitActivity<T extends ResidentComponent> {
    boolean isFinishing();

    @NonNull
    T createResidentComponent();

    void setResidentComponent(@NonNull T res);

    @NonNull
    T getResidentComponent();
}
