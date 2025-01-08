// Generated by Dagger (https://dagger.dev).
package com.app.airmenu.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Modules_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Gson> gsonProvider;

  public Modules_ProvideRetrofitFactory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(gsonProvider.get());
  }

  public static Modules_ProvideRetrofitFactory create(Provider<Gson> gsonProvider) {
    return new Modules_ProvideRetrofitFactory(gsonProvider);
  }

  public static Retrofit provideRetrofit(Gson gson) {
    return Preconditions.checkNotNullFromProvides(Modules.INSTANCE.provideRetrofit(gson));
  }
}
