package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Base class for activities part of Forge unit
 *
 * @param <T>
 */
public interface UnitActivity<T extends ResidentComponent> {
    boolean isFinishing();

    /**
     * Creates instance of the resident component
     *
     * @return resident component
     */
    @NonNull
    T createResidentComponent();


    /**
     * Returns the resident component
     *
     * @return Activity's resident component
     */
    @NonNull
    T getResidentComponent();


    /**
     * Sets the resident component
     * @param res resident component
     */
    void setResident(@NonNull T res);


    /**
     * Convenience alias of {@link #getResidentComponent}
     *
     * @return
     */
    @NonNull
    T getResident();


    /**
     * Convenience alias of {@link #getResidentComponent}
     *
     * @return resident component
     */
    @NonNull
    T getRes();
}
