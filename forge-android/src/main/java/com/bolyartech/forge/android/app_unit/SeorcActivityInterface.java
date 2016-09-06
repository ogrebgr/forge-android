package com.bolyartech.forge.android.app_unit;

@SuppressWarnings("SpellCheckingInspection")
public interface SeorcActivityInterface<RESULT, ERROR> extends OrcActivityInterface {
    ERROR getLastError();
    RESULT getLastResult();
}
