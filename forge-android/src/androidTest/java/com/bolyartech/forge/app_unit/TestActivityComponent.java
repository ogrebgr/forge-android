package com.bolyartech.forge.app_unit;

import android.os.Bundle;


/**
 * Created by ogre on 2015-10-22
 */
public class TestActivityComponent extends ActivityComponentImpl {
    @Override
    public ResidentComponent createResidentComponent() {
        return new TestResidentComponent();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponentTestDaggerComponent di = DaggerActivityComponentTestDaggerComponent.builder().build();
        di.inject(this);
    }
}
