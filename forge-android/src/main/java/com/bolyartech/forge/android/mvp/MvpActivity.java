package com.bolyartech.forge.android.mvp;

import android.view.View;

import com.bolyartech.forge.android.app_unit.UnitActivity;


public interface MvpActivity extends UnitActivity, Host {
    ActivityView createView();
    Presenter createPresenter(ActivityView actView);
}
