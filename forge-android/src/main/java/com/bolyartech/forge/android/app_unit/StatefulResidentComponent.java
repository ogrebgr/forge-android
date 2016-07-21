package com.bolyartech.forge.android.app_unit;

public interface StatefulResidentComponent extends ResidentComponent {
    ResidentComponentState getState();
    void stateHandled();
}
