package com.app.airmenu.network.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u001dBS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/app/airmenu/network/response/StoreDetails;", "", "avgPrepTime", "", "contactEmails", "", "location", "Lcom/app/airmenu/network/response/StoreDetails$Location;", "name", "", "priceBucket", "rawHeroUrl", "status", "storeId", "timezone", "(ILjava/util/List;Lcom/app/airmenu/network/response/StoreDetails$Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvgPrepTime", "()I", "getContactEmails", "()Ljava/util/List;", "getLocation", "()Lcom/app/airmenu/network/response/StoreDetails$Location;", "getName", "()Ljava/lang/String;", "getPriceBucket", "getRawHeroUrl", "getStatus", "getStoreId", "getTimezone", "Location", "app_debug"})
public final class StoreDetails {
    @com.google.gson.annotations.SerializedName(value = "avg_prep_time")
    private final int avgPrepTime = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "contact_emails")
    private final java.util.List<java.lang.Object> contactEmails = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "location")
    private final com.app.airmenu.network.response.StoreDetails.Location location = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "price_bucket")
    private final java.lang.String priceBucket = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "raw_hero_url")
    private final java.lang.String rawHeroUrl = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "store_id")
    private final java.lang.String storeId = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "timezone")
    private final java.lang.String timezone = null;
    
    public StoreDetails(int avgPrepTime, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> contactEmails, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.network.response.StoreDetails.Location location, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String priceBucket, @org.jetbrains.annotations.NotNull()
    java.lang.String rawHeroUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String storeId, @org.jetbrains.annotations.NotNull()
    java.lang.String timezone) {
        super();
    }
    
    public final int getAvgPrepTime() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getContactEmails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.network.response.StoreDetails.Location getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPriceBucket() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRawHeroUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStoreId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimezone() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/app/airmenu/network/response/StoreDetails$Location;", "", "address", "", "address2", "city", "country", "latitude", "", "longitude", "postalCode", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAddress2", "getCity", "getCountry", "getLatitude", "()D", "getLongitude", "getPostalCode", "getState", "app_debug"})
    public static final class Location {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "address")
        private final java.lang.String address = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "address_2")
        private final java.lang.String address2 = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "city")
        private final java.lang.String city = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "country")
        private final java.lang.String country = null;
        @com.google.gson.annotations.SerializedName(value = "latitude")
        private final double latitude = 0.0;
        @com.google.gson.annotations.SerializedName(value = "longitude")
        private final double longitude = 0.0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "postal_code")
        private final java.lang.String postalCode = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "state")
        private final java.lang.String state = null;
        
        public Location(@org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.NotNull()
        java.lang.String address2, @org.jetbrains.annotations.NotNull()
        java.lang.String city, @org.jetbrains.annotations.NotNull()
        java.lang.String country, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
        java.lang.String postalCode, @org.jetbrains.annotations.NotNull()
        java.lang.String state) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddress2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCountry() {
            return null;
        }
        
        public final double getLatitude() {
            return 0.0;
        }
        
        public final double getLongitude() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPostalCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getState() {
            return null;
        }
    }
}