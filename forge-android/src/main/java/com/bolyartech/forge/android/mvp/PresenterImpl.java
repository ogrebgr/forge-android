package com.bolyartech.forge.android.mvp;

import com.bolyartech.forge.android.app_unit.ResidentComponent;


abstract public class PresenterImpl<T extends Model, U extends P2V, V extends Host> implements Presenter {
    private T mModel;
    private U mP2V;
    private V mHost;


    public PresenterImpl(T model, U p2v, V host) {
        mModel = model;
        mP2V = p2v;
        mHost = host;
    }


    protected T getModel() {
        return mModel;
    }


    protected U getP2V() {
        return mP2V;
    }


    protected V getHost() {
        return mHost;
    }


    @Override
    public void onCreate() {
        // empty
    }


    @Override
    public void onDestroy() {
        mModel = null;
        mP2V = null;
        mHost = null;
    }
}
