package com.bolyartech.forge.android.app_unit.rc_task.task;


import static com.bolyartech.forge.base.misc.ForgeMessageFormat.format;


public class RcTaskResult<SUCCESS_VALUE, ERROR_VALUE> {
    private final SUCCESS_VALUE successValue;
    private final ERROR_VALUE errorValue;

    private final boolean isSuccess;


    RcTaskResult(boolean isSuccess, SUCCESS_VALUE successValue, ERROR_VALUE errorValue) {
        this.isSuccess = isSuccess;
        this.successValue = successValue;
        this.errorValue = errorValue;
    }


    public static <SUCCESS_VALUE, ERROR_VALUE> RcTaskResult<SUCCESS_VALUE, ERROR_VALUE>
    createSuccessResult(SUCCESS_VALUE successValue) {

        return new RcTaskResult<>(true, successValue, null);
    }


    public static <SUCCESS_VALUE, ERROR_VALUE> RcTaskResult<SUCCESS_VALUE, ERROR_VALUE>
    createErrorResult(ERROR_VALUE errorValue) {

        return new RcTaskResult<>(false, null, errorValue);
    }

    public boolean isSuccess() {
        return isSuccess;
    }


    public boolean isFailure() {
        return !isSuccess;
    }


    public SUCCESS_VALUE getSuccessValue() {
        return successValue;
    }


    public ERROR_VALUE getErrorValue() {
        return errorValue;
    }
}
