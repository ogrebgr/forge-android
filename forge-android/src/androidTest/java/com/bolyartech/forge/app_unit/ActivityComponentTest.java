package com.bolyartech.forge.app_unit;

import android.test.ActivityInstrumentationTestCase2;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by ogre on 2015-10-22
 */
public class ActivityComponentTest extends ActivityInstrumentationTestCase2<TestActivityComponent> {
    public ActivityComponentTest() {
        super(TestActivityComponent.class);
    }


    public void test_callTroughs() {
        final TestActivityComponent act = getActivity();
        final UnitManager um = act.mUnitManager;

        verify(um, times(1)).onActivityResumed(act);


        act.onPause();
        verify(um, times(1)).onActivityPaused(act);

        act.finish();


        getInstrumentation().waitForIdle(new Runnable() {
            @Override
            public void run() {
                verify(um, times(2)).onActivityPaused(act);
                verify(um, times(1)).onActivityFinishing(act);
            }
        });
    }
}
