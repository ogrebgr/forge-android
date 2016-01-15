package com.bolyartech.forge.app_unit;

import android.app.Application;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class UnitApplication_MembersInjector implements MembersInjector<UnitApplication> {
  private final MembersInjector<Application> supertypeInjector;
  private final Provider<UnitManager> mUnitManagerProvider;

  public UnitApplication_MembersInjector(MembersInjector<Application> supertypeInjector, Provider<UnitManager> mUnitManagerProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mUnitManagerProvider != null;
    this.mUnitManagerProvider = mUnitManagerProvider;
  }

  @Override
  public void injectMembers(UnitApplication instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mUnitManager = mUnitManagerProvider.get();
  }

  public static MembersInjector<UnitApplication> create(MembersInjector<Application> supertypeInjector, Provider<UnitManager> mUnitManagerProvider) {  
      return new UnitApplication_MembersInjector(supertypeInjector, mUnitManagerProvider);
  }
}

