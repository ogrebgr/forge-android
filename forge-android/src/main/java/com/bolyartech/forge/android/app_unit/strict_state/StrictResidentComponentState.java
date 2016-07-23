package com.bolyartech.forge.android.app_unit.strict_state;

public interface StrictResidentComponentState {
    Type getType();

    enum Type {
        START,
        TRANSIENT,
        END
    }
}
