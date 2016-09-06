package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Base class for activities part of Forge unit
 *
 * @param <T>
 */
public interface UnitActivity<T extends ActivityInterface> {
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
    void setResidentInterface(@NonNull T ri);


    /**
     * Returns the resident component
     *
     * @return Activity's resident component
     */
    @NonNull
    T getResidentInterface();


    /**
     * Convenience alias of {@link #getResidentInterface}
     *
     * @return
     */
    @NonNull
    T getRi();
}
