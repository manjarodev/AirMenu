// Generated by Dagger (https://dagger.dev).
package com.app.airmenu.ui.notification;

import com.app.airmenu.local.PreferenceRepository;
import com.app.airmenu.remote.RemoteRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NotificationAccessViewModel_Factory implements Factory<NotificationAccessViewModel> {
  private final Provider<RemoteRepository> remoteRepositoryProvider;

  private final Provider<PreferenceRepository> preferenceRepositoryProvider;

  public NotificationAccessViewModel_Factory(Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    this.remoteRepositoryProvider = remoteRepositoryProvider;
    this.preferenceRepositoryProvider = preferenceRepositoryProvider;
  }

  @Override
  public NotificationAccessViewModel get() {
    return newInstance(remoteRepositoryProvider.get(), preferenceRepositoryProvider.get());
  }

  public static NotificationAccessViewModel_Factory create(
      Provider<RemoteRepository> remoteRepositoryProvider,
      Provider<PreferenceRepository> preferenceRepositoryProvider) {
    return new NotificationAccessViewModel_Factory(remoteRepositoryProvider, preferenceRepositoryProvider);
  }

  public static NotificationAccessViewModel newInstance(RemoteRepository remoteRepository,
      PreferenceRepository preferenceRepository) {
    return new NotificationAccessViewModel(remoteRepository, preferenceRepository);
  }
}