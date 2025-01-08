package com.app.airmenu.ui.uberlogin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00152\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/app/airmenu/ui/uberlogin/StoresAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/airmenu/ui/uberlogin/StoresAdapter$ViewHolder;", "context_", "Landroid/content/Context;", "storesList", "", "Lcom/app/airmenu/network/response/UberStores$Store;", "(Landroid/content/Context;Ljava/util/List;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "onStoreClick", "Lkotlin/Function1;", "", "getOnStoreClick", "()Lkotlin/jvm/functions/Function1;", "setOnStoreClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class StoresAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.airmenu.ui.uberlogin.StoresAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.app.airmenu.network.response.UberStores.Store, kotlin.Unit> onStoreClick;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.app.airmenu.network.response.UberStores.Store> list;
    
    public StoresAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context_, @org.jetbrains.annotations.NotNull()
    java.util.List<com.app.airmenu.network.response.UberStores.Store> storesList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<com.app.airmenu.network.response.UberStores.Store, kotlin.Unit> getOnStoreClick() {
        return null;
    }
    
    public final void setOnStoreClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.app.airmenu.network.response.UberStores.Store, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.app.airmenu.network.response.UberStores.Store> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.app.airmenu.network.response.UberStores.Store> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.app.airmenu.ui.uberlogin.StoresAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.ui.uberlogin.StoresAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n\u00a8\u0006\u001e"}, d2 = {"Lcom/app/airmenu/ui/uberlogin/StoresAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/app/airmenu/ui/uberlogin/StoresAdapter;Landroid/view/View;)V", "storeAddress", "Landroid/widget/TextView;", "getStoreAddress", "()Landroid/widget/TextView;", "setStoreAddress", "(Landroid/widget/TextView;)V", "storeCountry", "getStoreCountry", "setStoreCountry", "storeImage", "Landroid/widget/ImageView;", "getStoreImage", "()Landroid/widget/ImageView;", "setStoreImage", "(Landroid/widget/ImageView;)V", "storeName", "getStoreName", "setStoreName", "storeStatus", "getStoreStatus", "setStoreStatus", "bind", "", "store", "Lcom/app/airmenu/network/response/UberStores$Store;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView storeName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView storeAddress;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView storeCountry;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView storeStatus;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView storeImage;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStoreName() {
            return null;
        }
        
        public final void setStoreName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStoreAddress() {
            return null;
        }
        
        public final void setStoreAddress(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStoreCountry() {
            return null;
        }
        
        public final void setStoreCountry(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStoreStatus() {
            return null;
        }
        
        public final void setStoreStatus(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getStoreImage() {
            return null;
        }
        
        public final void setStoreImage(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.app.airmenu.network.response.UberStores.Store store) {
        }
    }
}