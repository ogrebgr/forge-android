package com.bolyartech.forge.android.app_unit;

public interface StatefulResidentComponent<T extends Enum<T> & ResidentComponentState> extends ResidentComponent {
    T getState();
    void stateHandled();
}
