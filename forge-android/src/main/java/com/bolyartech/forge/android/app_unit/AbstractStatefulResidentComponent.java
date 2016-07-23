package com.bolyartech.forge.android.app_unit;

abstract public class AbstractStatefulResidentComponent<T extends Enum<T>>
        extends AbstractResidentComponent implements StatefulResidentComponent<T> {

    
    private final StateManager<T> mStateManager;


    public AbstractStatefulResidentComponent(StateManager<T> stateManager) {
        mStateManager = stateManager;
    }


    @Override
    public T getState() {
        return mStateManager.getState();
    }



    @Override
    public boolean isInState(T state) {
        return mStateManager.getState() == state;
    }


    @SafeVarargs
    @Override
    public final boolean isInOneOf(T state, T... states) {
        if (mStateManager.getState() == state) {
            return true;
        }

        if (states.length > 0) {
            for(T st : states) {
                if (mStateManager.getState() == st) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    protected void switchToState(T state) {
        mStateManager.switchToState(state);
    }

    protected void resetState() {
        mStateManager.reset();
    }
}
