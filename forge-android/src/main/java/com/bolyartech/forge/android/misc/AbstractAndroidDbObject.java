package com.bolyartech.forge.android.misc;

import android.database.sqlite.SQLiteDatabase;


abstract public class AbstractAndroidDbObject<T> implements AndroidDbObject<T> {
    private SQLiteDatabase mDbc;


    public AbstractAndroidDbObject(SQLiteDatabase dbc) {
        setDbc(dbc);
    }


    @Override
    public void setDbc(SQLiteDatabase dbc) {
        if (!dbc.isOpen()) {
            throw new IllegalArgumentException("dbc is not open");
        }

        mDbc = dbc;
    }


    @Override
    public boolean isDbcOpen() {
        if (mDbc != null) {
            return mDbc.isOpen();
        } else {
            return false;
        }
    }


    @Override
    public SQLiteDatabase getDbc() {
        return mDbc;
    }
}
