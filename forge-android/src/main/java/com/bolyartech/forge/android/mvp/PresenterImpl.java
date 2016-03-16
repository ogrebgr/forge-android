package com.bolyartech.forge.android.mvp;

import com.bolyartech.forge.android.app_unit.ResidentComponent;


abstract public class PresenterImpl implements Presenter {
    private Model mModel;
    private ActivityView mView;
    private Host mHost;


    public PresenterImpl(Model model, ActivityView view, Host host) {
        mModel = model;
        mView = view;
        mHost = host;
    }


    protected Model getModel() {
        return mModel;
    }


    protected ActivityView getView() {
        return mView;
    }


    protected Host getHost() {
        return mHost;
    }


    @Override
    public void onCreate() {
        // empty
    }


    @Override
    public void onDestroy() {
        mModel = null;
        mView = null;
        mHost = null;
    }
}
