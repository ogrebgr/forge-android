package com.bolyartech.forge.android.app_unit;

abstract public class AbstractStatefulResidentComponent<T extends Enum<T> & ResidentComponentState>
        extends AbstractResidentComponent implements StatefulResidentComponent<T> {

    
    protected final StateManager<T> mStateManager;


    public AbstractStatefulResidentComponent(StateManager<T> stateManager) {
        mStateManager = stateManager;
    }


    @Override
    public T getState() {
        return mStateManager.getState();
    }


    @Override
    public void stateHandled() {
        if (mStateManager.getState().getType() == ResidentComponentState.Type.END) {
            mStateManager.reset();
        }
    }
}
