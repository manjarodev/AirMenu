// Generated by Dagger (https://dagger.dev).
package com.app.airmenu.ui.home;

import com.app.airmenu.local.PreferenceRepository;
import com.app.airmenu.remote.RemoteRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<RemoteRepository> remoteRepositoryProvider;

  private final Provider<PreferenceRepository> preferenceRepositoryProvider;

  public HomeViewModel_Factory(Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    this.remoteRepositoryProvider = remoteRepositoryProvider;
    this.preferenceRepositoryProvider = preferenceRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(remoteRepositoryProvider.get(), preferenceRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    return new HomeViewModel_Factory(remoteRepositoryProvider, preferenceRepositoryProvider);
  }

  public static HomeViewModel newInstance(RemoteRepository remoteRepository,
      PreferenceRepository preferenceRepository) {
    return new HomeViewModel(remoteRepository, preferenceRepository);
  }
}