package com.bolyartech.forge.android.misc;

import android.app.Activity;
import android.content.Intent;


/**
 * Helper class that encapsulates result for Activity after <code>startActivityForResult</code>
 */
@SuppressWarnings("unused")
public final class ActivityResult {
    /**
     * The request code that you provided to startActivityForResult()
     */
    public final int requestCode;
    /**
     * Result code returned by the activity
     */
    public final int resultCode;
    /**
     * Data returned by the activity
     */
    @SuppressWarnings("WeakerAccess")
    public final Intent data;


    /**
     * Creates new ActivityResult
     * @param requestCode  Request code that you provided to startActivityForResult()
     * @param resultCode  Result code returned by the activity
     * @param data  Data returned by the activity
     */
    public ActivityResult(int requestCode, int resultCode, Intent data) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        if (data != null) {
            this.data = new Intent(data);
        } else {
            this.data = null;
        }

    }


    /**
     * Checks if the result is Activity.RESULT_OK
     * @return true if result is Activity.RESULT_OK
     */
    public boolean isOk() {
        return resultCode == Activity.RESULT_OK;
    }


    /**
     * Checks if the result is Activity.RESULT_CANCELED
     * @return true if result is Activity.RESULT_CANCELED
     */
    public boolean isCanceled() {
        return resultCode == Activity.RESULT_CANCELED;
    }


    /**
     * Gets result code
     * @return Activity.RESULT_OK or Activity.RESULT_CANCELED
     */
    public int getResultCode() {
        return resultCode;
    }


    /**
     * Gets request code
     * @return Request code that you provided to startActivityForResult()
     */
    public int getRequestCode() {
        return requestCode;
    }


    /**
     * Gets the data intent
     * @return Data returned by the activity
     */
    public Intent getData() {
        return data;
    }
}
