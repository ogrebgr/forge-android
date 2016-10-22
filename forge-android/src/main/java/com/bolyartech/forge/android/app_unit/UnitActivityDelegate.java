package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Delegate to be used for unit base activities which implement UnitActivity interface
 *
 * @param <T> Type of the resident component
 */
public final class UnitActivityDelegate<T> {
    private T mResident;


    /**
     * Sets the resident
     * @param resident resident component
     */
    public void setResident(@NonNull T resident) {
        mResident = resident;
    }


    /**
     * Gets the resident
     * @return resident component
     */
    @NonNull
    public T getResident() {
        return mResident;
    }


    /**
     *
     * Gets the resident.
     * Alias of {{@link #getResident()}}
     * @return resident component
     */
    @NonNull
    public T getRes() {
        return getResident();
    }
}
