package com.bolyartech.forge.android.misc;

import android.os.Environment;


/**
 * Helper class for working with the external storage
 */
@SuppressWarnings("unused")
public class ExternalStorageHelper {
    private ExternalStorageHelper() {
        throw new AssertionError("Non-instantiable utility class");
    }


    /**
     * Checks the state of the external storage
     * @return State of the external storage
     */
    public static ExternalStorageState checkState() {
        boolean externalStorageAvailable;
        boolean externalStorageWritable;

        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            externalStorageAvailable = externalStorageWritable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            externalStorageAvailable = true;
            externalStorageWritable = false;
        } else {
            externalStorageAvailable = externalStorageWritable = false;
        }

        return new ExternalStorageState(externalStorageAvailable, externalStorageWritable);
    }


    /**
     * Helper class
     */
    public static class ExternalStorageState {
        public final boolean isAvailable;
        public final boolean isWritable;


        public ExternalStorageState(boolean isAvailable, boolean isWritable) {
            this.isAvailable = isAvailable;
            this.isWritable = isWritable;
        }
    }
}
