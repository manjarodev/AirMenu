package com.app.airmenu.ui;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/app/airmenu/ui/UberOrderNotification;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "adapter", "Lcom/app/airmenu/ui/UberOrderNotification$NotificationAdapter;", "binding", "Lcom/app/airmenu/databinding/ActivityUberOrderNotificationBinding;", "sessionManager", "Lcom/app/airmenu/session/SessionManager;", "viewModel", "Lcom/app/airmenu/room/database/DatabaseViewModel;", "getAndDisplayUberNotification", "", "initVariables", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "NotificationAdapter", "app_debug"})
public final class UberOrderNotification extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = null;
    private com.app.airmenu.databinding.ActivityUberOrderNotificationBinding binding;
    private com.app.airmenu.session.SessionManager sessionManager;
    private com.app.airmenu.ui.UberOrderNotification.NotificationAdapter adapter;
    private com.app.airmenu.room.database.DatabaseViewModel viewModel;
    
    public UberOrderNotification() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initVariables() {
    }
    
    private final void getAndDisplayUberNotification() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001fB%\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/app/airmenu/ui/UberOrderNotification$NotificationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/airmenu/ui/UberOrderNotification$NotificationAdapter$ViewHolder;", "Lcom/app/airmenu/ui/UberOrderNotification;", "data", "Ljava/util/ArrayList;", "Lcom/app/airmenu/room/model/UberNotification;", "Lkotlin/collections/ArrayList;", "_context", "Landroid/content/Context;", "(Lcom/app/airmenu/ui/UberOrderNotification;Ljava/util/ArrayList;Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "list", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class NotificationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.airmenu.ui.UberOrderNotification.NotificationAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private java.util.ArrayList<com.app.airmenu.room.model.UberNotification> list;
        @org.jetbrains.annotations.NotNull()
        private android.content.Context context;
        
        public NotificationAdapter(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.app.airmenu.room.model.UberNotification> data, @org.jetbrains.annotations.NotNull()
        android.content.Context _context) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.app.airmenu.room.model.UberNotification> getList() {
            return null;
        }
        
        public final void setList(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.app.airmenu.room.model.UberNotification> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.NotNull()
        android.content.Context p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.app.airmenu.ui.UberOrderNotification.NotificationAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.app.airmenu.ui.UberOrderNotification.NotificationAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/app/airmenu/ui/UberOrderNotification$NotificationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/app/airmenu/ui/UberOrderNotification$NotificationAdapter;Landroid/view/View;)V", "localTime", "Landroid/widget/TextView;", "getLocalTime", "()Landroid/widget/TextView;", "setLocalTime", "(Landroid/widget/TextView;)V", "orderId", "getOrderId", "setOrderId", "status", "getStatus", "setStatus", "storeId", "getStoreId", "setStoreId", "timemstamp", "getTimemstamp", "setTimemstamp", "bind", "", "get", "Lcom/app/airmenu/room/model/UberNotification;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private android.widget.TextView orderId;
            @org.jetbrains.annotations.NotNull()
            private android.widget.TextView storeId;
            @org.jetbrains.annotations.NotNull()
            private android.widget.TextView localTime;
            @org.jetbrains.annotations.NotNull()
            private android.widget.TextView timemstamp;
            @org.jetbrains.annotations.NotNull()
            private android.widget.TextView status;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            android.view.View itemView) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getOrderId() {
                return null;
            }
            
            public final void setOrderId(@org.jetbrains.annotations.NotNull()
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getStoreId() {
                return null;
            }
            
            public final void setStoreId(@org.jetbrains.annotations.NotNull()
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getLocalTime() {
                return null;
            }
            
            public final void setLocalTime(@org.jetbrains.annotations.NotNull()
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTimemstamp() {
                return null;
            }
            
            public final void setTimemstamp(@org.jetbrains.annotations.NotNull()
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getStatus() {
                return null;
            }
            
            public final void setStatus(@org.jetbrains.annotations.NotNull()
            android.widget.TextView p0) {
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.app.airmenu.room.model.UberNotification get) {
            }
        }
    }
}