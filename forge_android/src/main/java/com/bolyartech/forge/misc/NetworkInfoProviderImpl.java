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

package com.bolyartech.forge.misc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;


public class NetworkInfoProviderImpl implements NetworkInfoProvider {
    private final Context mContext;


    @Inject
    public NetworkInfoProviderImpl(Context context) {
        super();
        mContext = context;
    }


    @Override
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return isWifiConnected(connMgr) || isMobileConnected(connMgr);
    }


    @Override
    public boolean isWifiConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return isWifiConnected(connMgr);
    }


    @Override
    public boolean isMobileConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return isMobileConnected(connMgr);
    }


    private boolean isWifiConnected(ConnectivityManager connMgr) {
        NetworkInfo networkInfoWifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return networkInfoWifi != null && networkInfoWifi.isConnectedOrConnecting();
    }


    private boolean isMobileConnected(ConnectivityManager connMgr) {
        NetworkInfo networkInfoMobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfoMobile != null && networkInfoMobile.isConnectedOrConnecting();
    }
}
