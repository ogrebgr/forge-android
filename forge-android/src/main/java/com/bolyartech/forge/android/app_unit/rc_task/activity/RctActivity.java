package com.bolyartech.forge.android.app_unit.rc_task.activity;

import com.bolyartech.forge.android.app_unit.rc_task.RctResidentComponent;
import com.bolyartech.forge.android.misc.ActivityResult;


public interface RctActivity {
    void handleActivityResult(ActivityResult activityResult);

    void handleResidentIdleState();

    void handleResidentBusyState();

    void handleResidentEndedState();

    RctResidentComponent getRes();

    RctResidentComponent getResident();

    void onResumeJustCreated();
}
