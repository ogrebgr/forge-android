package com.bolyartech.forge.android.app_unit;

public final class OperationOutcome<RESULT, ERROR> {
    private final boolean mIsSuccessful;
    private final boolean mIsAborted;
    private final RESULT mResult;
    private final ERROR mError;


    public static <RES, ERR> OperationOutcome<RES, ERR> createSuccessOutcome(RES result) {
        return new OperationOutcome<>(true, false, result, null);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createErrorOutcome(ERR error) {
        return new OperationOutcome<>(false, false, null, error);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createAbortedOutcome() {
        return new OperationOutcome<>(false, true, null, null);
    }


    private OperationOutcome(boolean isSuccessful, boolean isAborted, RESULT result, ERROR error) {
        // we don't check for valid combinations of the parameters because the only way to call this constructor is
        // via static factory methods

        mIsSuccessful = isSuccessful;
        mIsAborted = isAborted;
        mResult = result;
        mError = error;
    }


    public boolean isSuccessful() {
        return mIsSuccessful;
    }


    public boolean isAborted() {
        return mIsAborted;
    }


    public RESULT getResult() {
        return mResult;
    }


    public ERROR getError() {
        return mError;
    }
}
