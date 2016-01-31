/*
 * Copyright (C) 2012-2015 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bolyartech.forge.android.misc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;


/**
 * Utility class that contains static methods for working with activities
 */
public class ActivityUtils {
    /**
     * Noninstantiable utility class
     */
    private ActivityUtils() {
        throw new AssertionError();
    }


    /**
     * Intercepts long parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both -1 is returned
     */
    public static long interceptLongParam(Bundle savedInstanceState,
                                          Intent intent, String paramName
    ) {
        long ret = -1;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getLong(paramName);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getLong(paramName);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts Parcelable parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both <code>null</code> is returned
     */
    public static Parcelable interceptParcelableParam(
            Bundle savedInstanceState,
            Intent intent,
            String paramName
    ) {
        Parcelable ret = null;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getParcelable(paramName);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getParcelable(paramName);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts String parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both <code>null</code> is returned
     */
    public static String interceptStringParam(Bundle savedInstanceState,
                                              Intent intent, String paramName
    ) {
        String ret = null;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getString(paramName);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getString(paramName);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts boolean parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both <code>false</code> is returned
     */
    public static boolean interceptBooleanParam(Bundle savedInstanceState,
                                                Intent intent, String paramName
    ) {
        boolean ret = false;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getBoolean(paramName, false);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getBoolean(paramName, false);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts int parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both -1 is returned
     */
    public static int interceptIntParam(Bundle savedInstanceState,
                                        Intent intent, String paramName
    ) {
        int ret = -1;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getInt(paramName, -1);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getInt(paramName, -1);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts float parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both 0 is returned
     */
    public static float interceptFloatParam(Bundle savedInstanceState,
                                            Intent intent, String paramName
    ) {
        float ret = 0;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getFloat(paramName, 0);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getFloat(paramName, 0);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts double parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both 0 is returned
     */
    public static double interceptDoubleParam(Bundle savedInstanceState,
                                              Intent intent, String paramName
    ) {
        double ret = 0;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getDouble(paramName, 0);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getDouble(paramName, 0);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts byte parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both 0 is returned
     */
    public static byte interceptByteParam(Bundle savedInstanceState,
                                          Intent intent, String paramName
    ) {
        byte ret = 0;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getByte(paramName, (byte) 0);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getByte(paramName, (byte) 0);
                }
            }
        }

        return ret;
    }


    /**
     * Intercepts char parameter from <code>savedInstanceState</code> or
     * intent (that was used to launch activity with)
     *
     * @param savedInstanceState instance state as passed to {@link android.app.Activity#onCreate(Bundle)}
     * @param intent             Intent that was used to start current activity.
     * @param paramName          Name of the parameter to be intercepted
     * @return Parameter's value as found in 1. savedInstanceState or 2. intent.getExtras(). If not found in both 0 is returned
     */
    public static char interceptCharParam(Bundle savedInstanceState,
                                          Intent intent, String paramName
    ) {
        char ret = 0;

        if (savedInstanceState != null) {
            ret = savedInstanceState.getChar(paramName, (char) 0);
        } else {
            if (intent != null) {
                Bundle incoming = intent.getExtras();
                if (incoming != null) {
                    ret = incoming.getChar(paramName, (char) 0);
                }
            }
        }

        return ret;
    }
}
