package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.content.Intent;


public final class ActivityResultContainer {
    private final int mRequestCode;
    private final int mResultCode;
    private final Intent mData;


    public ActivityResultContainer(int requestCode, int resultCode, Intent data) {
        mRequestCode = requestCode;
        mResultCode = resultCode;
        mData = new Intent(data);
    }


    public boolean isOk() {
        return mResultCode == Activity.RESULT_OK;
    }


    public boolean isCanceled() {
        return mResultCode == Activity.RESULT_CANCELED;
    }


    public int getResultCode() {
        return mResultCode;
    }


    public int getRequestCode() {
        return mRequestCode;
    }


    public Intent getData() {
        return mData;
    }
}
