package com.app.airmenu.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020,H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006-"}, d2 = {"Lcom/app/airmenu/service/ExtraInfo2;", "", "aDDRESS", "", "cAPACITY", "iTEMAVAILABILITY", "mISSINGINFO", "mISSINGITEM", "oTHER", "pOSNOTREADY", "pOSOFFLINE", "pRICING", "sPECIALINSTRUCTIONS", "sTORECLOSED", "(ZZZZZZZZZZZ)V", "getADDRESS", "()Z", "getCAPACITY", "getITEMAVAILABILITY", "getMISSINGINFO", "getMISSINGITEM", "getOTHER", "getPOSNOTREADY", "getPOSOFFLINE", "getPRICING", "getSPECIALINSTRUCTIONS", "getSTORECLOSED", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class ExtraInfo2 {
    @com.google.gson.annotations.SerializedName(value = "ADDRESS")
    private final boolean aDDRESS = false;
    @com.google.gson.annotations.SerializedName(value = "CAPACITY")
    private final boolean cAPACITY = false;
    @com.google.gson.annotations.SerializedName(value = "ITEM_AVAILABILITY")
    private final boolean iTEMAVAILABILITY = false;
    @com.google.gson.annotations.SerializedName(value = "MISSING_INFO")
    private final boolean mISSINGINFO = false;
    @com.google.gson.annotations.SerializedName(value = "MISSING_ITEM")
    private final boolean mISSINGITEM = false;
    @com.google.gson.annotations.SerializedName(value = "OTHER")
    private final boolean oTHER = false;
    @com.google.gson.annotations.SerializedName(value = "POS_NOT_READY")
    private final boolean pOSNOTREADY = false;
    @com.google.gson.annotations.SerializedName(value = "POS_OFFLINE")
    private final boolean pOSOFFLINE = false;
    @com.google.gson.annotations.SerializedName(value = "PRICING")
    private final boolean pRICING = false;
    @com.google.gson.annotations.SerializedName(value = "SPECIAL_INSTRUCTIONS")
    private final boolean sPECIALINSTRUCTIONS = false;
    @com.google.gson.annotations.SerializedName(value = "STORE_CLOSED")
    private final boolean sTORECLOSED = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.service.ExtraInfo2 copy(boolean aDDRESS, boolean cAPACITY, boolean iTEMAVAILABILITY, boolean mISSINGINFO, boolean mISSINGITEM, boolean oTHER, boolean pOSNOTREADY, boolean pOSOFFLINE, boolean pRICING, boolean sPECIALINSTRUCTIONS, boolean sTORECLOSED) {
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
    
    public ExtraInfo2(boolean aDDRESS, boolean cAPACITY, boolean iTEMAVAILABILITY, boolean mISSINGINFO, boolean mISSINGITEM, boolean oTHER, boolean pOSNOTREADY, boolean pOSOFFLINE, boolean pRICING, boolean sPECIALINSTRUCTIONS, boolean sTORECLOSED) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getADDRESS() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean getCAPACITY() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getITEMAVAILABILITY() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getMISSINGINFO() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getMISSINGITEM() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getOTHER() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getPOSNOTREADY() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getPOSOFFLINE() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getPRICING() {
        return false;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getSPECIALINSTRUCTIONS() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getSTORECLOSED() {
        return false;
    }
}