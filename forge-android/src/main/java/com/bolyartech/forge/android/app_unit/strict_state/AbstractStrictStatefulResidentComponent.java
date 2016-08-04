package com.bolyartech.forge.android.app_unit.strict_state;

import com.bolyartech.forge.android.app_unit.AbstractStatefulResidentComponent;
import com.bolyartech.forge.android.app_unit.StatefulResidentComponent;


abstract public class AbstractStrictStatefulResidentComponent<T extends Enum<T> & StrictResidentComponentState>
        extends AbstractStatefulResidentComponent<T> implements StatefulResidentComponent<T> {

    public AbstractStrictStatefulResidentComponent(T initialState) {
        super(initialState);
    }
}