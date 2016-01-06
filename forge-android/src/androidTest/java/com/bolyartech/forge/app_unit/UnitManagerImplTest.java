package com.bolyartech.forge.app_unit;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by ogre on 2015-10-22
 */
public class UnitManagerImplTest {
    /**
     * Tests if component is created on first resume of the activity
     */
    @Test
    public void test_onActivityResumedNew() {
        ActivityComponent act1 = mock(ActivityComponent.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(act1.createResidentComponent()).thenReturn(comp1);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);

        ResidentComponent active = um.getActiveResidentComponent();
        assertTrue(active == comp1);
    }


    /**
     * Tests if component for second activity is created and made active
     */
    @Test
    public void test_onActivityResumedSecond() {
        Act1 act1 = mock(Act1.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(act1.createResidentComponent()).thenReturn(comp1);

        Act2 act2 = mock(Act2.class);
        ResidentComponent comp2 = mock(ResidentComponent.class);
        when(act2.createResidentComponent()).thenReturn(comp2);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);
        um.onActivityPaused(act1);
        ResidentComponent active = um.getActiveResidentComponent();
        assertTrue(active == comp1);

        um.onActivityResumed(act2);
        active = um.getActiveResidentComponent();
        assertTrue(active == comp2);
    }


    /**
     * Tests if component is recreated when found dead
     */
    @Test
    public void test_onActivityResumedDead() {
        Act1 act1 = mock(Act1.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(act1.createResidentComponent()).thenReturn(comp1);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);
        um.onActivityPaused(act1);

        ResidentComponent comp2 = mock(ResidentComponent.class);
        when(comp1.isDead()).thenReturn(true);
        when(act1.createResidentComponent()).thenReturn(comp2);

        um.onActivityResumed(act1);
        ResidentComponent active = um.getActiveResidentComponent();
        assertTrue(active == comp2);
    }


    /**
     * Tests if component onResume is called correct number of times
     */
    @Test
    public void test_onActivityCallTroughCount() {
        Act1 act1 = mock(Act1.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(act1.createResidentComponent()).thenReturn(comp1);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);
        um.onActivityPaused(act1);
        verify(comp1, times(1)).onActivityResumed(act1);
        verify(comp1, times(1)).onActivityPaused();
        verify(comp1, times(0)).onActivityStop();

        um.onActivityResumed(act1);
        verify(comp1, times(2)).onActivityResumed(act1);
        verify(comp1, times(1)).onActivityPaused();
        verify(comp1, times(0)).onActivityStop();

        um.onActivityStop(act1);
        verify(comp1, times(2)).onActivityResumed(act1);
        verify(comp1, times(1)).onActivityPaused();
        verify(comp1, times(1)).onActivityStop();
    }


    @Test
    public void test_onActivityFinishing() {
        Act1 act1 = mock(Act1.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(act1.createResidentComponent()).thenReturn(comp1);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);
        um.onActivityPaused(act1);
        um.onActivityStop(act1);

        ResidentComponent comp = um.getActiveResidentComponent();
        assertTrue(comp == null);
    }


    /**
     * Tests if dead components are removed
     */
    @Test
    public void test_onActivityResumedAddRemovePair() {
        Act1 act1 = mock(Act1.class);
        ResidentComponent comp1 = mock(ResidentComponent.class);
        when(comp1.isDead()).thenReturn(true);
        when(act1.createResidentComponent()).thenReturn(comp1);

        UnitManagerImpl um = new UnitManagerImpl();
        um.onActivityResumed(act1);
        um.onActivityPaused(act1);

        Map<Class<? extends ActivityComponent>, ResidentComponent> map1 = um.getResidentComponents();
        assertTrue(map1.size() == 0);
        Map<ResidentComponent, Class<? extends ActivityComponent>> map2 = um.getResidentComponentsReverse();
        assertTrue(map2.size() == 0);

        ResidentComponent comp2 = mock(ResidentComponent.class);

        Act2 act2 = mock(Act2.class);
        when(act2.createResidentComponent()).thenReturn(comp2);

        um.onActivityResumed(act2);

        map1 = um.getResidentComponents();
        assertTrue(map1.size() == 1);
        map2 = um.getResidentComponentsReverse();
        assertTrue(map2.size() == 1);
    }
}
