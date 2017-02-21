package com.bolyartech.forge.android.app_unit;

public interface Abortable {
    /**
     * Aborts the current operation and switches to idle state
     */
    void abort();
}
