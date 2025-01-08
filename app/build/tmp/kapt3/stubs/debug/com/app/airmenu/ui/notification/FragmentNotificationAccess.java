package com.app.airmenu.ui.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/app/airmenu/ui/notification/FragmentNotificationAccess;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/app/airmenu/databinding/FragmentNotificationAccessBinding;", "dialog", "Lcom/app/airmenu/utils/TransparentProgressDialog;", "mViewModel", "Lcom/app/airmenu/ui/notification/NotificationAccessViewModel;", "getMViewModel", "()Lcom/app/airmenu/ui/notification/NotificationAccessViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "serviceDestroyBroadcast", "Lcom/app/airmenu/broadcast/OnServiceDestroyReceiver;", "getServiceDestroyBroadcast", "()Lcom/app/airmenu/broadcast/OnServiceDestroyReceiver;", "setServiceDestroyBroadcast", "(Lcom/app/airmenu/broadcast/OnServiceDestroyReceiver;)V", "navigate", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setUpSpinner", "enterpriseNames", "", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class FragmentNotificationAccess extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.app.airmenu.broadcast.OnServiceDestroyReceiver serviceDestroyBroadcast;
    private final kotlin.Lazy mViewModel$delegate = null;
    private com.app.airmenu.databinding.FragmentNotificationAccessBinding binding;
    private com.app.airmenu.utils.TransparentProgressDialog dialog;
    
    public FragmentNotificationAccess() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.broadcast.OnServiceDestroyReceiver getServiceDestroyBroadcast() {
        return null;
    }
    
    public final void setServiceDestroyBroadcast(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.broadcast.OnServiceDestroyReceiver p0) {
    }
    
    private final com.app.airmenu.ui.notification.NotificationAccessViewModel getMViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navigate() {
    }
    
    private final void setUpSpinner(java.util.List<java.lang.String> enterpriseNames) {
    }
}