package com.bolyartech.forge.app_unit;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;


/**
 * Created by ogre on 2015-10-23
 */
@Module
public class ActivityComponentTestDaggerModule {
    @Provides
    public UnitManager providesUnitManager() {
        return mock(UnitManager.class);
    }
}
