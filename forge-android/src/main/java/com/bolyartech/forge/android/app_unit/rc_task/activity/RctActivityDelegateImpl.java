package com.bolyartech.forge.android.app_unit.rc_task.activity;

import android.content.Intent;

import com.bolyartech.forge.android.misc.ActivityResult;
import com.bolyartech.forge.android.misc.RunOnUiThreadHelper;

import org.slf4j.LoggerFactory;


public final class RctActivityDelegateImpl implements RctActivityDelegate {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RctActivity activity;

    private ActivityResult activityResult;

    private boolean isActivityJustCreated = true;

    private RunOnUiThreadHelper runOnUiThreadHelper;


    public RctActivityDelegateImpl(RctActivity activity, RunOnUiThreadHelper runOnUiThreadHelper) {
        this.activity = activity;
        this.runOnUiThreadHelper = runOnUiThreadHelper;
    }


    @Override
    public void onResume() {
        if (activityResult != null) {
            activity.handleActivityResult(activityResult);
            activityResult = null;
        } else {
            handleState();
        }
    }


    @Override
    public boolean isActivityJustCreated() {
        return isActivityJustCreated;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        activityResult = new ActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onResidentTaskExecutionStateChanged() {
        handleState();
    }


    protected synchronized void handleState() {
        logger.trace("{} state {}", activity.getClass(), activity.getRes().getTaskExecutionState());

        switch (activity.getRes().getTaskExecutionState()) {
            case IDLE:
                runOnUiThreadHelper.runOnUiThread(() -> {
                    activity.handleResidentIdleState();
                    isActivityJustCreated = false;
                });

                break;
            case BUSY:
                runOnUiThreadHelper.runOnUiThread(activity::handleResidentBusyState);

                break;
            case ENDED:
                runOnUiThreadHelper.runOnUiThread(() -> {
                    activity.handleResidentEndedState();
                    activity.getRes().ack();
                });

                break;
        }
    }
}
