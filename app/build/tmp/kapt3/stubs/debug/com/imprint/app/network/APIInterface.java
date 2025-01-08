package com.imprint.app.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'JR\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H\'J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'JH\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\'J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J6\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$2\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010\'\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\u0006H\'J\"\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'J\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'\u00a8\u0006."}, d2 = {"Lcom/imprint/app/network/APIInterface;", "", "acceptOrder", "Lretrofit2/Call;", "Lcom/squareup/okhttp/ResponseBody;", "orderId", "", "body", "Lorg/json/JSONObject;", "cancelOrder", "Lokhttp3/RequestBody;", "deProisionStore", "Lokhttp3/ResponseBody;", "storeId", "denyOrder", "getAccessToken", "Lcom/app/airmenu/network/response/TokenResponse;", "url", "id", "secret", "grantType", "code", "redirecet_uri", "getMerchantStores", "Lcom/app/airmenu/network/response/UberStores;", "getOrderDetails", "Lcom/app/airmenu/network/response/OrderDetail;", "getOrderToken", "scope", "getPOSStatus", "Lcom/app/airmenu/network/response/POSStatus;", "getRestaurantStatus", "Lcom/app/airmenu/network/response/RestaurantStatus;", "getStoreDetails", "Lcom/app/airmenu/network/response/StoreDetails;", "login", "Lretrofit2/Response;", "action", "version", "key", "data", "setRestaurantStatus", "Lcom/app/airmenu/network/response/POSAvailability;", "setupPOS", "updateDeliveryStatus", "updatePOSStatus", "app_debug"})
public abstract interface APIInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.app.airmenu.network.response.TokenResponse> getOrderToken(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Url()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "client_id")
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "client_secret")
    java.lang.String secret, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "grant_type")
    java.lang.String grantType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "scope")
    java.lang.String scope);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v1/eats/stores?limit=10")
    public abstract retrofit2.Call<com.app.airmenu.network.response.UberStores> getMerchantStores();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.app.airmenu.network.response.TokenResponse> getAccessToken(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Url()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "client_id")
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "client_secret")
    java.lang.String secret, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "grant_type")
    java.lang.String grantType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "code")
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "redirect_uri")
    java.lang.String redirecet_uri);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v2/eats/order/{order_id}")
    public abstract retrofit2.Call<com.app.airmenu.network.response.OrderDetail> getOrderDetails(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "order_id", encoded = true)
    java.lang.String orderId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/stores/{store_id}/pos_data")
    public abstract retrofit2.Call<okhttp3.ResponseBody> setupPOS(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    org.json.JSONObject body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v1/eats/stores/{store_id}/pos_data")
    public abstract retrofit2.Call<com.app.airmenu.network.response.POSStatus> getPOSStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "/v1/eats/stores/{store_id}/pos_data")
    public abstract retrofit2.Call<com.app.airmenu.network.response.POSStatus> updatePOSStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "/v1/eats/stores/{store_id}/pos_data")
    public abstract retrofit2.Call<okhttp3.ResponseBody> deProisionStore(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/orders/{order_id}/accept_pos_order")
    public abstract retrofit2.Call<com.squareup.okhttp.ResponseBody> acceptOrder(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "order_id", encoded = true)
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    org.json.JSONObject body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/orders/{order_id}/deny_pos_order")
    public abstract retrofit2.Call<com.squareup.okhttp.ResponseBody> denyOrder(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "order_id", encoded = true)
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/orders/{order_id}/cancel")
    public abstract retrofit2.Call<com.squareup.okhttp.ResponseBody> cancelOrder(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "order_id", encoded = true)
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST()
    public abstract retrofit2.Response<okhttp3.ResponseBody> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "ACTION")
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "VERSION")
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "KEY")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "DATA")
    java.lang.String data);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/store/{store_id}/status")
    public abstract retrofit2.Call<com.app.airmenu.network.response.POSAvailability> setRestaurantStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v1/eats/store/{store_id}/status")
    public abstract retrofit2.Call<com.app.airmenu.network.response.RestaurantStatus> getRestaurantStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/eats/orders/{order_id}/restaurantdelivery/status")
    public abstract retrofit2.Call<com.squareup.okhttp.ResponseBody> updateDeliveryStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "order_id", encoded = true)
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v1/eats/stores/{store_id}")
    public abstract retrofit2.Call<com.app.airmenu.network.response.StoreDetails> getStoreDetails(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "store_id", encoded = true)
    java.lang.String storeId);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}