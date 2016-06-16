package com.bolyartech.forge.android.misc;

import android.database.sqlite.SQLiteDatabase;


public interface AndroidDbObject<T> {
    T save(SQLiteDatabase dbc);
}
