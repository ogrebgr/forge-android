package com.bolyartech.forge.android.app_unit;

public interface StateManager<T extends Enum<T>> {
    T getState();
    void switchToState(T state);
    void reset();
}
