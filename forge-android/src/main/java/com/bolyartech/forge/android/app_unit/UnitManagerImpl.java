package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.base.misc.ForUnitTestsOnly;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


/**
 * Created by ogre on 2015-10-22
 */
public class UnitManagerImpl implements UnitManager {
    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private final Map<Class<? extends UnitActivity>, ResidentComponent> mResidentComponents = new HashMap<>();
    private final Map<ResidentComponent, Class<? extends UnitActivity>> mResidentComponentsReverse = new HashMap<>();
    private ResidentComponent mActiveResidentComponent;


    @Inject
    public UnitManagerImpl() {
    }


    @Override
    public ResidentComponent onActivityResumed(UnitActivity act) {
        mLogger.trace("Activity resumed: {}", act.getClass().getSimpleName());
        ResidentComponent comp = mResidentComponents.get(act.getClass());
        if (comp == null) {
            createNewComponent(act);
        } else {
            if (comp.isDead()) {
                removeComponentPair(comp);
                createNewComponent(act);
            } else {
                if (comp != mActiveResidentComponent) {
                    mActiveResidentComponent = comp;
                }

                mActiveResidentComponent.onActivityResumed(act);
            }
        }
        act.setResidentComponent(mActiveResidentComponent);
        return mActiveResidentComponent;
    }


    @Override
    public void onActivityPaused(UnitActivity act) {
        mLogger.trace("Activity paused: {}", act.getClass().getSimpleName());
        if (mActiveResidentComponent != null) {
            ResidentComponent comp = mResidentComponents.get(act.getClass());
            if (mActiveResidentComponent == comp) {
                mActiveResidentComponent.onActivityPaused();
                if (mActiveResidentComponent.isDead()) {
                    removeComponentPair(mActiveResidentComponent);
                }
            } else {
                throw new IllegalStateException("mActiveResidentComponent not present in mResidentComponents: "
                        + mActiveResidentComponent.getClass().getSimpleName());
            }
        }
    }


    @Override
    public void onActivityStopped(UnitActivity act) {
        mLogger.trace("Activity stop: {}", act.getClass().getSimpleName());
        if (act.isFinishing()) {
            mLogger.trace("Activity finishing: {}", act.getClass().getSimpleName());
            ResidentComponent comp = mResidentComponents.get(act.getClass());
            comp.onActivityFinishing();
            removeComponentPair(comp);

            if (mActiveResidentComponent == comp) {
                mActiveResidentComponent = null;
            }
        }
    }


    /**
     * This method basically does the same as #onActivityStopped. It's purpose is the same but it covers the case
     * when onStop() is not called because user called finish() in onCreate() in their activity (for example)
     * @param act
     */
    @Override
    public void onActivityDestroyed(UnitActivity act) {
        mLogger.trace("Activity destroy: {}", act.getClass().getSimpleName());

        if (act.isFinishing()) {
            ResidentComponent comp = mResidentComponents.get(act.getClass());
            if (comp != null) {
                comp.onActivityFinishing();
                removeComponentPair(comp);

                if (mActiveResidentComponent == comp) {
                    mActiveResidentComponent = null;
                }
            }
        }
    }


    @Override
    public ResidentComponent getActiveResidentComponent() {
        return mActiveResidentComponent;
    }


    @ForUnitTestsOnly
    Map<Class<? extends UnitActivity>, ResidentComponent> getResidentComponents() {
        return new HashMap<>(mResidentComponents);
    }


    @ForUnitTestsOnly
    Map<ResidentComponent, Class<? extends UnitActivity>> getResidentComponentsReverse() {
        return new HashMap<>(mResidentComponentsReverse);
    }


    private void createNewComponent(UnitActivity act) {
        ResidentComponent comp = act.createResidentComponent();
        addComponentPair(act.getClass(), comp);

        comp.onCreate();
        mActiveResidentComponent = comp;
        comp.onActivityResumed(act);
    }


    private void addComponentPair(Class<? extends UnitActivity> clazz, ResidentComponent comp) {
        mResidentComponents.put(clazz, comp);
        mResidentComponentsReverse.put(comp, clazz);
    }


    private void removeComponentPair(ResidentComponent comp) {
        Class<? extends UnitActivity> clazz = mResidentComponentsReverse.remove(comp);
        mResidentComponents.remove(clazz);
    }
}
