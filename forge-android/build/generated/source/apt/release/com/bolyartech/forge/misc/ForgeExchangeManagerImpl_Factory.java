package com.bolyartech.forge.misc;

import com.bolyartech.forge.app_unit.UnitManager;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ForgeExchangeManagerImpl_Factory implements Factory<ForgeExchangeManagerImpl> {
  private final Provider<UnitManager> unitManagerProvider;
  private final Provider<ForgeExchangeFunctionality> forgeExchangeFunctionalityProvider;

  public ForgeExchangeManagerImpl_Factory(Provider<UnitManager> unitManagerProvider, Provider<ForgeExchangeFunctionality> forgeExchangeFunctionalityProvider) {  
    assert unitManagerProvider != null;
    this.unitManagerProvider = unitManagerProvider;
    assert forgeExchangeFunctionalityProvider != null;
    this.forgeExchangeFunctionalityProvider = forgeExchangeFunctionalityProvider;
  }

  @Override
  public ForgeExchangeManagerImpl get() {  
    return new ForgeExchangeManagerImpl(unitManagerProvider.get(), forgeExchangeFunctionalityProvider.get());
  }

  public static Factory<ForgeExchangeManagerImpl> create(Provider<UnitManager> unitManagerProvider, Provider<ForgeExchangeFunctionality> forgeExchangeFunctionalityProvider) {  
    return new ForgeExchangeManagerImpl_Factory(unitManagerProvider, forgeExchangeFunctionalityProvider);
  }
}

