package com.bolyartech.forge.android.app_unit;

/**
 * @deprecated Please use the new rc_task functionality {@link com.bolyartech.forge.android.app_unit.rc_task.AbstractRctResidentComponent}
 */
public interface Abortable {
    /**
     * Aborts the current operation and switches to idle state
     */
    void abort();
}
