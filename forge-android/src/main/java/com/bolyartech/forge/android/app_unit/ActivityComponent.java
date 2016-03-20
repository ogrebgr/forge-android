package com.bolyartech.forge.android.app_unit;

import android.os.Bundle;


/**
 * Created by ogre on 2015-10-26
 */
public interface ActivityComponent {
    boolean isFinishing();

    ResidentComponent createResidentComponent();

    void setResidentComponent(ResidentComponent res);

    ResidentComponent getResidentComponent();
}
