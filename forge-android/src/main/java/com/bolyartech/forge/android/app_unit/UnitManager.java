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

package com.bolyartech.forge.android.app_unit;

/**
 * Manages the lifecycle of the resident components. Its job is to listen for activity
 * lifecycle events (which are fed to it by {@link UnitApplication})
 *
 * All methods here are called <b>after</b> corresponding method in the activity is called, e.g. first Activity's
 * onCreate() is called and then UnitManager's onActivityCreated()
 */
public interface UnitManager {
    /**
     * Called after activity is created
     * @param act Activity
     */
    void onActivityCreated(UnitActivity act);

    /**
     * Called after activity is resumed
     * @param act Activity
     */
    void onActivityResumed(UnitActivity act);

    /**
     * Called after activity is paused
     * @param act Activity
     */
    void onActivityPaused(UnitActivity act);

    /**
     * Called after activity is stopped
     * @param act Activity
     */
    void onActivityStopped(UnitActivity act);

    /**
     * Called after activity is destroyed
     * @param act Activity
     */
    void onActivityDestroyed(UnitActivity act);

    /**
     * Returns active (current) resident component
     * @return active resident componet
     */
    ResidentComponent getActiveResidentComponent();
}
