package com.bolyartech.forge.android.app_unit;

public interface StatefulResidentComponent<T extends Enum<T>> extends ResidentComponent {
    T getState();
    void stateHandled();
    boolean isInState(T state);
    @SuppressWarnings("unchecked")
    boolean isInOneOfStates(T state, T... states);

}
