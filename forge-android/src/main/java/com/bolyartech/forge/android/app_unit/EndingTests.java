package com.bolyartech.forge.android.app_unit;

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
