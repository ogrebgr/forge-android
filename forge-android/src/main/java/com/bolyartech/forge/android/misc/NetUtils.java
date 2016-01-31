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

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Utility class that provides static methods for working with network
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NetUtils {
    /**
     * Noninstantiable utility class
     */
    private NetUtils() {
        throw new AssertionError();
    }


    /**
     * Checks if there is network connection
     *
     * @param context Current context
     * @return <code>true</code> if there is network connection, <code>false</code> otherwise.
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
