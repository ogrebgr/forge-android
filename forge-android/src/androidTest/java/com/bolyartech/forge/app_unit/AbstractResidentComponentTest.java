package com.bolyartech.forge.app_unit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Created by ogre on 2015-10-22
 */
public class AbstractResidentComponentTest {
    @Test
    public void test_onActivityResumed() {
        Act1 act1 = mock(Act1.class);

        AbstractResidentComponent res = new TestResidentComponent();
        res.onActivityResumed(act1);

        assertTrue(res.getActivity() == act1);
    }


    @Test
    public void test_liveAndDeath() {
        Act1 act1 = mock(Act1.class);

        AbstractResidentComponent res = new TestResidentComponent();
        res.onActivityResumed(act1);
        assertFalse(res.isDead());

        res.die();
        assertTrue(res.isDead());
    }
}
