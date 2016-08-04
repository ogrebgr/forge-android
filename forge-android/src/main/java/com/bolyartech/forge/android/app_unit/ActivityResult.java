package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.content.Intent;


public final class ActivityResult {
    public final int requestCode;
    public final int resultCode;
    public final Intent data;


    public ActivityResult(int requestCode, int resultCode, Intent data) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = new Intent(data);
    }


    public boolean isOk() {
        return resultCode == Activity.RESULT_OK;
    }


    public boolean isCanceled() {
        return resultCode == Activity.RESULT_CANCELED;
    }


    public int getResultCode() {
        return resultCode;
    }


    public int getRequestCode() {
        return requestCode;
    }


    public Intent getData() {
        return data;
    }
}
