package com.bolyartech.forge.android.app_unit;

/**
 * @param <RESULT>
 * @param <ERROR>
 * @deprecated Please use the new rc_task functionality {@link com.bolyartech.forge.android.app_unit.rc_task.task.RcTaskResult}
 */
public final class OperationOutcome<RESULT, ERROR> {
    private final boolean mIsSuccessful;
    private final RESULT mResult;
    private final ERROR mError;


    private OperationOutcome(boolean isSuccessful, RESULT result, ERROR error) {
        // we don't check for valid combinations of the parameters because the only way to call this constructor is
        // via static factory methods

        mIsSuccessful = isSuccessful;
        mResult = result;
        mError = error;
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createSuccessOutcome(RES result) {
        return new OperationOutcome<>(true, result, null);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createErrorOutcome(ERR error) {
        return new OperationOutcome<>(false, null, error);
    }


    public static <RES, ERR> OperationOutcome<RES, ERR> createAbortedOutcome() {
        return new OperationOutcome<>(false, null, null);
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
