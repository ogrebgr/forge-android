package com.bolyartech.forge.app_unit;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public enum UnitManagerImpl_Factory implements Factory<UnitManagerImpl> {
INSTANCE;

  @Override
  public UnitManagerImpl get() {  
    return new UnitManagerImpl();
  }

  public static Factory<UnitManagerImpl> create() {  
    return INSTANCE;
  }
}

