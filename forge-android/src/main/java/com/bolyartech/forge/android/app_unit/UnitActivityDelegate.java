package com.bolyartech.forge.android.app_unit;

import android.support.annotation.NonNull;


/**
 * Delegate to be used for unit base activities which implement UnitActivity interface
 *
 * @param <T> Type of the resident component
 */
public final class UnitActivityDelegate<T> {
    private T mResident;


    public void setResident(@NonNull T resident) {
        mResident = resident;
    }


    @NonNull
    public T getResident() {
        return mResident;
    }


    @NonNull
    public T getRes() {
        return getResident();
    }
}
