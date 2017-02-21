package com.bolyartech.forge.android.app_unit;

/**
 * States for stateful operation resident components
 */
public enum OpState {
    /**
     * Defines idle state, i.e. not working on operation, just waiting
     */
    IDLE,
    /**
     * Defines busy state, i.e. working on operation
     */
    BUSY,
    /**
     * Defines end state, i.e. operation has ended (and result or error might be available)
     */
    ENDED
}
