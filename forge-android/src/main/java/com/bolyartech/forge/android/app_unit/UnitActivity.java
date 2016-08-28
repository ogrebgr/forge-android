package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


public interface UnitActivity<T extends ResidentComponent> {
    boolean isFinishing();

    @NonNull
    T createResidentComponent();

    void setResident(@NonNull T res);

    @NonNull
    T getResident();
    /**
     * Convenience alias of {@link #getResident}
     * @return resident component
     */
    @NonNull
    T getRes();
}
