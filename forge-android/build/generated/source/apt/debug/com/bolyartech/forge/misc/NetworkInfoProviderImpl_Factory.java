package com.bolyartech.forge.misc;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class NetworkInfoProviderImpl_Factory implements Factory<NetworkInfoProviderImpl> {
  private final Provider<Context> contextProvider;

  public NetworkInfoProviderImpl_Factory(Provider<Context> contextProvider) {  
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkInfoProviderImpl get() {  
    return new NetworkInfoProviderImpl(contextProvider.get());
  }

  public static Factory<NetworkInfoProviderImpl> create(Provider<Context> contextProvider) {  
    return new NetworkInfoProviderImpl_Factory(contextProvider);
  }
}

