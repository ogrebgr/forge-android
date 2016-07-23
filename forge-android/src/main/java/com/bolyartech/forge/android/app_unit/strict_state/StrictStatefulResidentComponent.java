package com.bolyartech.forge.android.app_unit.strict_state;

import com.bolyartech.forge.android.app_unit.StatefulResidentComponent;


public interface StrictStatefulResidentComponent<T extends Enum<T> & StrictResidentComponentState>
        extends StatefulResidentComponent<T> {


}
