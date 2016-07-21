package com.bolyartech.forge.android.app_unit;

public interface ResidentComponentState {
    Type getType();

    enum Type {
        START,
        TRANSIENT,
        END
    }
}
