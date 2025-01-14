// Generated by Dagger (https://dagger.dev).
package com.app.airmenu.ui.notification;

import com.app.airmenu.broadcast.OnServiceDestroyReceiver;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FragmentNotificationAccess_MembersInjector implements MembersInjector<FragmentNotificationAccess> {
  private final Provider<OnServiceDestroyReceiver> serviceDestroyBroadcastProvider;

  public FragmentNotificationAccess_MembersInjector(
      Provider<OnServiceDestroyReceiver> serviceDestroyBroadcastProvider) {
    this.serviceDestroyBroadcastProvider = serviceDestroyBroadcastProvider;
  }

  public static MembersInjector<FragmentNotificationAccess> create(
      Provider<OnServiceDestroyReceiver> serviceDestroyBroadcastProvider) {
    return new FragmentNotificationAccess_MembersInjector(serviceDestroyBroadcastProvider);
  }

  @Override
  public void injectMembers(FragmentNotificationAccess instance) {
    injectServiceDestroyBroadcast(instance, serviceDestroyBroadcastProvider.get());
  }

  @InjectedFieldSignature("com.app.airmenu.ui.notification.FragmentNotificationAccess.serviceDestroyBroadcast")
  public static void injectServiceDestroyBroadcast(FragmentNotificationAccess instance,
      OnServiceDestroyReceiver serviceDestroyBroadcast) {
    instance.serviceDestroyBroadcast = serviceDestroyBroadcast;
  }
}
