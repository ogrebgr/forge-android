package com.bolyartech.forge.android.app_unit.rc_task.activity;

import android.content.Intent;


public interface RctActivityDelegate {
    void onResume();
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onResidentTaskExecutionStateChanged();
}
