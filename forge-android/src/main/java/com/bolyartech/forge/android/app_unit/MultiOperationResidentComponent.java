package com.bolyartech.forge.android.app_unit;

public interface MultiOperationResidentComponent<T extends Enum<T>> extends OperationResidentComponent {
    T getCurrentOperation();
}
