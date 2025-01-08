package com.app.airmenu.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/app/airmenu/service/ExtraInfoCancel;", "", "outOfItems", "", "restaurantTooBusy", "customerCalledCancel", "kitchenClosed", "connotCompleteCustomerNote", "(ZZZZZ)V", "getConnotCompleteCustomerNote", "()Z", "getCustomerCalledCancel", "getKitchenClosed", "getOutOfItems", "getRestaurantTooBusy", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class ExtraInfoCancel {
    @com.google.gson.annotations.SerializedName(value = "OUT_OF_ITEMS")
    private final boolean outOfItems = false;
    @com.google.gson.annotations.SerializedName(value = "RESTAURANT_TOO_BUSY")
    private final boolean restaurantTooBusy = false;
    @com.google.gson.annotations.SerializedName(value = "CUSTOMER_CALLED_TO_CANCEL")
    private final boolean customerCalledCancel = false;
    @com.google.gson.annotations.SerializedName(value = "KITCHEN_CLOSED")
    private final boolean kitchenClosed = false;
    @com.google.gson.annotations.SerializedName(value = "CANNOT_COMPLETE_CUSTOMER_NOTE")
    private final boolean connotCompleteCustomerNote = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.service.ExtraInfoCancel copy(boolean outOfItems, boolean restaurantTooBusy, boolean customerCalledCancel, boolean kitchenClosed, boolean connotCompleteCustomerNote) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ExtraInfoCancel(boolean outOfItems, boolean restaurantTooBusy, boolean customerCalledCancel, boolean kitchenClosed, boolean connotCompleteCustomerNote) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getOutOfItems() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean getRestaurantTooBusy() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getCustomerCalledCancel() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getKitchenClosed() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getConnotCompleteCustomerNote() {
        return false;
    }
}