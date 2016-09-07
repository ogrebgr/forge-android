package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Base class for activities part of Forge unit
 *
 * @param <T>
 */
public interface UnitActivity<T> {
    boolean isFinishing();

    /**
     * Creates instance of the resident component
     *
     * @return resident component
     */
    @NonNull
    ResidentComponent createResidentComponent();

    /**
     * Sets the resident component
     * @param ri activity interface
     */
    void setResidentToActivity(@NonNull T ri);


    /**
     * Returns the resident component
     *
     * @return Activity's resident component
     */
    @NonNull
    T getResidentToActivity();


    /**
     * Convenience alias of {@link #getResidentToActivity}
     *
     * @return
     */
    @NonNull
    T getRta();
}
