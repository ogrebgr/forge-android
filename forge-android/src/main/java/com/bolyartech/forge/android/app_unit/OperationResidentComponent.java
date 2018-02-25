package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.android.app_unit.rc_task.RctResidentComponent;


/**
 * Operation resident component
 *
 * Uses simple finite state machine with 3 states:
 * <ul>
 *     <li>IDLE - when idle and ready to execute operation</li>
 *     <li>BUSY - when executing operations is in progress</li>
 *     <li>ENDED - when operation is ended</li>
 * </ul>
 * @deprecated Please use the new rc_task functionality {@link RctResidentComponent}
 */
public interface OperationResidentComponent extends ResidentComponent, OpStateful, Abortable, EndingTests {
    /**
     * Switches to busy state
     */
    void switchToBusyState();

    /**
     * Switches to ENDED state with success flag on
     */
    void switchToEndedStateSuccess();

    /**
     * Switches to ENDED state with success flag off
     */
    void switchToEndedStateFail();


    /**
     * Returns listener
     * @return listener
     */
    Listener getListener();


    /**
     * Listener to be notified when operation state changes
     */
    interface Listener {
        /**
         * Called when resident operation state changed.
         * Listeners (i.e. your activities) must not acquire locks or do lengthy operations in this method. Best
         * practice is to just do <code>runOnUiThread(() -> handleState(getRes().getTaskExecutionState()));</code>
         */
        void onResidentOperationStateChanged();
    }
}
