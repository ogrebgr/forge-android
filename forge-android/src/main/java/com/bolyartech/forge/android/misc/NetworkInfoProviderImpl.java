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
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import javax.inject.Inject;


/**
 * Provides information about network state
 */
public class NetworkInfoProviderImpl implements NetworkInfoProvider {
    private final Context mContext;


    /**
     * Create new NetworkInfoProviderImpl
     * @param context Context
     */
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
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            @SuppressWarnings("deprecation")
            NetworkInfo networkInfoWifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            return networkInfoWifi != null && networkInfoWifi.isConnectedOrConnecting();
        } else {
            Network[] networks = connMgr.getAllNetworks();
            NetworkInfo networkInfo;
            Network network;
            for (Network network1 : networks) {
                network = network1;
                networkInfo = connMgr.getNetworkInfo(network);
                if ((networkInfo.getType() == ConnectivityManager.TYPE_WIFI) && (networkInfo.getState().equals(NetworkInfo.State.CONNECTED))) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean isMobileConnected(ConnectivityManager connMgr) {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            @SuppressWarnings("deprecation")
            NetworkInfo networkInfoMobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            return networkInfoMobile != null && networkInfoMobile.isConnectedOrConnecting();
        } else {
            Network[] networks = connMgr.getAllNetworks();
            NetworkInfo networkInfo;
            Network network;
            for (Network network1 : networks) {
                network = network1;
                networkInfo = connMgr.getNetworkInfo(network);
                if ((networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) && (networkInfo.getState().equals(NetworkInfo.State.CONNECTED))) {
                    return true;
                }
            }
        }
        return false;
    }
}
