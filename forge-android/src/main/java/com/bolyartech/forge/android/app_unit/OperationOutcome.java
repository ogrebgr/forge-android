package com.bolyartech.forge.android.app_unit;

public class OperationOutcome<RESULT, ERROR> {
    private final boolean mIsSuccessful;
    private final RESULT mResult;
    private final ERROR mError;


    public OperationOutcome(boolean isSuccessful, RESULT result, ERROR error) {
        mIsSuccessful = isSuccessful;
        mResult = result;
        mError = error;
    }


    public boolean isSuccessful() {
        return mIsSuccessful;
    }


    public RESULT getResult() {
        return mResult;
    }


    public ERROR getError() {
        return mError;
    }
}
