package com.bolyartech.forge.android.misc;

import android.app.Activity;
import android.content.Intent;


/**
 * Helper class that encapsulates result for Activity after <code>startActivityForResult</code>
 */
@SuppressWarnings("unused")
public final class ActivityResult {
    public final int requestCode;
    public final int resultCode;
    @SuppressWarnings("WeakerAccess")
    public final Intent data;


    public ActivityResult(int requestCode, int resultCode, Intent data) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        if (data != null) {
            this.data = new Intent(data);
        } else {
            this.data = null;
        }

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
