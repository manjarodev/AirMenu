// Generated by Dagger (https://dagger.dev).
package com.app.airmenu.ui.divisionIds;

import com.app.airmenu.local.PreferenceRepository;
import com.app.airmenu.remote.RemoteRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DivisionIdsViewModel_Factory implements Factory<DivisionIdsViewModel> {
  private final Provider<RemoteRepository> remoteRepositoryProvider;

  private final Provider<PreferenceRepository> preferenceRepositoryProvider;

  public DivisionIdsViewModel_Factory(Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    this.remoteRepositoryProvider = remoteRepositoryProvider;
    this.preferenceRepositoryProvider = preferenceRepositoryProvider;
  }

  @Override
  public DivisionIdsViewModel get() {
    return newInstance(remoteRepositoryProvider.get(), preferenceRepositoryProvider.get());
  }

  public static DivisionIdsViewModel_Factory create(
      Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    return new DivisionIdsViewModel_Factory(remoteRepositoryProvider, preferenceRepositoryProvider);
  }

  public static DivisionIdsViewModel newInstance(RemoteRepository remoteRepository,
      PreferenceRepository preferenceRepository) {
    return new DivisionIdsViewModel(remoteRepository, preferenceRepository);
  }
}
