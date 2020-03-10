package com.bolyartech.forge.android.app_unit.rc_task.activity;

import com.bolyartech.forge.android.app_unit.rc_task.RctResidentComponent;
import com.bolyartech.forge.android.misc.ActivityResult;


public interface RctActivity {
    /**
     * Override this method to handle the activity result (after startActivityForResult()). Avoid using onActivityResult() because it
     * called before onResume() and thus you cannot safely start task execution safely from there
     * @param activityResult Activity result wrapper
     */
    void handleActivityResult(ActivityResult activityResult);

    /**
     * Called then the resident component switch to IDLE state, i.e. after #handleResidentEndedState() returns OR it the task is
     * aborted
     */
    void handleResidentIdleState();

    /**
     * Called when the resident component switch to BUSY state, i.e. after task execution begins
     */
    void handleResidentBusyState();

    /**
     * Called when the resident component switch to ENDED state, i.e. after task is completed (successfully or not)
     */
    void handleResidentEndedState();

    /**
     * Returns the resident component. Alias of #getResident()
     * @return resident component
     */
    RctResidentComponent getRes();

    /**
     * Returns the resident component
     * @return resident component
     */
    RctResidentComponent getResident();

    /**
     * Convenience method which is called when activity is just created. This is the place to start
     * a task (and not in onCreate() or onStarted() because you may miss task ending)
     */
    void onResumeJustCreated();

    /**
     * Convenience method which is called when activity is resumed but not just created
     * @see #onResumeJustCreated
     */
    void onResumeNotJustCreated();
}
