package com.bolyartech.forge.android.misc;

import android.database.sqlite.SQLiteDatabase;


public interface AndroidDbObject<T> {
    T save();
    void setDbc(SQLiteDatabase dbc);
    SQLiteDatabase getDbc();
    boolean isDbcOpen();
}
