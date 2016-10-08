package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Base class for activities part of Forge unit
 *
 * @param <T>
 */
public interface UnitActivity<T extends ResidentComponent> {
    /**
     * Is activity finishing?
     * @return true if it is finishing
     */
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
    void setResident(@NonNull T ri);


    /**
     * Returns the resident component
     *
     * @return Activity's resident component
     */
    @NonNull
    T getResident();


    /**
     * Convenience alias of {@link #getResident}
     *
     * @return Activity's resident component
     */
    @NonNull
    T getRes();
}
