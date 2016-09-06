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

/**
 * Provides information about network connectivity
 */
@SuppressWarnings("unused")
public interface NetworkInfoProvider {
    /**
     * Checks if WiFi is connected
     * @return true if connected, false otherwise
     */
    boolean isWifiConnected();

    /**
     * Checks if GSM/3G/LTE data is connected
     * @return true if connected, false otherwise
     */
    boolean isMobileConnected();

    /**
     * Checks if there is internet connectivity (WiFi and/or mobile)
     * @return true if connected, false otherwise
     */
    boolean isConnected();
}
