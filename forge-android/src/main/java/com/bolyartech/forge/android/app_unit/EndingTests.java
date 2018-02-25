package com.bolyartech.forge.android.app_unit;

/**
 * @deprecated Please use the new rc_task functionality {@link com.bolyartech.forge.android.app_unit.rc_task.AbstractRctResidentComponent}
 */
public interface EndingTests {
    /**
     * Convenience alias of {@link #isEndedSuccessfully}
     *
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isSuccess();

    /**
     * @return true if last operation was marked as successful, false otherwise
     */
    boolean isEndedSuccessfully();
}
