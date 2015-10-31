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

package com.bolyartech.forge.app_unit;

import android.app.Activity;

import org.slf4j.LoggerFactory;

import javax.inject.Inject;


abstract public class ActivityComponentImpl extends Activity implements ActivityComponent {
    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass()
            .getSimpleName());

    @Inject
    UnitManager mUnitManager;
    private ResidentComponent mResidentComponent;


    public org.slf4j.Logger getLogger() {
        return mLogger;
    }


    @Override
    public void onResume() {
        super.onResume();

        mResidentComponent = mUnitManager.onActivityResumed(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mUnitManager.onActivityPaused(this);
    }


    protected ResidentComponent getResidentComponent() {
        return mResidentComponent;
    }


    @Override
    public void onStop() {
        super.onStop();
        if (isFinishing()) {
            mUnitManager.onActivityFinishing(this);
            mResidentComponent = null;
        }
    }
}
