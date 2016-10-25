package com.bolyartech.forge.android.app_unit;

public final class OperationOutcome<RESULT, ERROR> {
    private final boolean mIsSuccessful;
    private final RESULT mResult;
    private final ERROR mError;


    public static <RES, ERR> OperationOutcome<RES, ERR> createSuccessOutcome(RES result) {
        return new OperationOutcome<>(true, result, null);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createErrorOutcome(ERR error) {
        return new OperationOutcome<>(false, null, error);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createAbortedOutcome() {
        return new OperationOutcome<>(false, null, null);
    }


    private OperationOutcome(boolean isSuccessful, RESULT result, ERROR error) {
        // we don't check for valid combinations of the parameters because the only way to call this constructor is
        // via static factory methods

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
