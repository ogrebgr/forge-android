package com.bolyartech.forge.app_unit;

import dagger.Component;


/**
 * Created by ogre on 2015-10-23
 */
@Component(modules = ActivityComponentTestDaggerModule.class)
public interface ActivityComponentTestDaggerComponent {
    void inject(TestActivityComponent act);
}
