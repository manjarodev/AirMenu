package com.app.airmenu.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu;", "", "action", "", "orders", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders;", "status", "statusCode", "", "version", "(Ljava/lang/String;Lcom/app/airmenu/models/OrderResponseAirMenu$Orders;Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getOrders", "()Lcom/app/airmenu/models/OrderResponseAirMenu$Orders;", "getStatus", "getStatusCode", "()I", "getVersion", "Orders", "app_debug"})
public final class OrderResponseAirMenu {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "action")
    private final java.lang.String action = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "orders")
    private final com.app.airmenu.models.OrderResponseAirMenu.Orders orders = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "statusCode")
    private final int statusCode = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "version")
    private final java.lang.String version = null;
    
    public OrderResponseAirMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.models.OrderResponseAirMenu.Orders orders, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int statusCode, @org.jetbrains.annotations.NotNull()
    java.lang.String version) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.models.OrderResponseAirMenu.Orders getOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int getStatusCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVersion() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders;", "", "uK", "", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK;", "(Ljava/util/List;)V", "getUK", "()Ljava/util/List;", "UK", "app_debug"})
    public static final class Orders {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "UK")
        private final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK> uK = null;
        
        public Orders(@org.jetbrains.annotations.NotNull()
        java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK> uK) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK> getUK() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b!\u0018\u00002\u00020\u0001:\u0003012B\u0097\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001aR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0016\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0016\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0016\u0010\u0019\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"\u00a8\u00063"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK;", "", "activeFlags", "", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$ActiveFlag;", "available", "", "childs", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$Child;", "extraInfo", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$ExtraInfo;", "firstName", "", "lastName", "menuRelation", "orderCounter", "", "orderDate", "", "orderId", "paymentMethod", "plu", "title", "trackingUrl", "userId", "username", "(Ljava/util/List;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActiveFlags", "()Ljava/util/List;", "getAvailable", "()Z", "getChilds", "getExtraInfo", "getFirstName", "()Ljava/lang/String;", "getLastName", "getMenuRelation", "getOrderCounter", "()I", "getOrderDate", "()J", "getOrderId", "getPaymentMethod", "getPlu", "getTitle", "getTrackingUrl", "getUserId", "getUsername", "ActiveFlag", "Child", "ExtraInfo", "app_debug"})
        public static final class UK {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "activeFlags")
            private final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ActiveFlag> activeFlags = null;
            @com.google.gson.annotations.SerializedName(value = "available")
            private final boolean available = false;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "childs")
            private final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child> childs = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "extraInfo")
            private final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ExtraInfo> extraInfo = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "firstName")
            private final java.lang.String firstName = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "lastName")
            private final java.lang.String lastName = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "menuRelation")
            private final java.lang.String menuRelation = null;
            @com.google.gson.annotations.SerializedName(value = "orderCounter")
            private final int orderCounter = 0;
            @com.google.gson.annotations.SerializedName(value = "orderDate")
            private final long orderDate = 0L;
            @com.google.gson.annotations.SerializedName(value = "orderId")
            private final int orderId = 0;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "paymentMethod")
            private final java.lang.String paymentMethod = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "plu")
            private final java.lang.String plu = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "title")
            private final java.lang.String title = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "trackingUrl")
            private final java.lang.String trackingUrl = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "userId")
            private final java.lang.String userId = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "username")
            private final java.lang.String username = null;
            
            public UK(@org.jetbrains.annotations.NotNull()
            java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ActiveFlag> activeFlags, boolean available, @org.jetbrains.annotations.NotNull()
            java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child> childs, @org.jetbrains.annotations.NotNull()
            java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ExtraInfo> extraInfo, @org.jetbrains.annotations.NotNull()
            java.lang.String firstName, @org.jetbrains.annotations.NotNull()
            java.lang.String lastName, @org.jetbrains.annotations.NotNull()
            java.lang.String menuRelation, int orderCounter, long orderDate, int orderId, @org.jetbrains.annotations.NotNull()
            java.lang.String paymentMethod, @org.jetbrains.annotations.NotNull()
            java.lang.String plu, @org.jetbrains.annotations.NotNull()
            java.lang.String title, @org.jetbrains.annotations.NotNull()
            java.lang.String trackingUrl, @org.jetbrains.annotations.NotNull()
            java.lang.String userId, @org.jetbrains.annotations.NotNull()
            java.lang.String username) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ActiveFlag> getActiveFlags() {
                return null;
            }
            
            public final boolean getAvailable() {
                return false;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child> getChilds() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.ExtraInfo> getExtraInfo() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getFirstName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getLastName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMenuRelation() {
                return null;
            }
            
            public final int getOrderCounter() {
                return 0;
            }
            
            public final long getOrderDate() {
                return 0L;
            }
            
            public final int getOrderId() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPaymentMethod() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPlu() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getTitle() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getTrackingUrl() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUserId() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUsername() {
                return null;
            }
            
            @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$ActiveFlag;", "", "datetime", "", "key", "", "operator", "operatorEmail", "orderId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDatetime", "()J", "getKey", "()Ljava/lang/String;", "getOperator", "getOperatorEmail", "getOrderId", "app_debug"})
            public static final class ActiveFlag {
                @com.google.gson.annotations.SerializedName(value = "datetime")
                private final long datetime = 0L;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "key")
                private final java.lang.String key = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "operator")
                private final java.lang.String operator = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "operatorEmail")
                private final java.lang.String operatorEmail = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "orderId")
                private final java.lang.String orderId = null;
                
                public ActiveFlag(long datetime, @org.jetbrains.annotations.NotNull()
                java.lang.String key, @org.jetbrains.annotations.NotNull()
                java.lang.String operator, @org.jetbrains.annotations.NotNull()
                java.lang.String operatorEmail, @org.jetbrains.annotations.NotNull()
                java.lang.String orderId) {
                    super();
                }
                
                public final long getDatetime() {
                    return 0L;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getKey() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getOperator() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getOperatorEmail() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getOrderId() {
                    return null;
                }
            }
            
            @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001 BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$Child;", "", "available", "", "childs", "", "count", "", "extraInfo", "Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$Child$ExtraInfo;", "id", "", "menuRelation", "plu", "price", "", "title", "(ZLjava/util/List;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;)V", "getAvailable", "()Z", "getChilds", "()Ljava/util/List;", "getCount", "()I", "getExtraInfo", "getId", "()Ljava/lang/String;", "getMenuRelation", "getPlu", "getPrice", "()D", "getTitle", "ExtraInfo", "app_debug"})
            public static final class Child {
                @com.google.gson.annotations.SerializedName(value = "available")
                private final boolean available = false;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "childs")
                private final java.util.List<java.lang.Object> childs = null;
                @com.google.gson.annotations.SerializedName(value = "count")
                private final int count = 0;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "extraInfo")
                private final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child.ExtraInfo> extraInfo = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "id")
                private final java.lang.String id = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "menuRelation")
                private final java.lang.String menuRelation = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "plu")
                private final java.lang.String plu = null;
                @com.google.gson.annotations.SerializedName(value = "price")
                private final double price = 0.0;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "title")
                private final java.lang.String title = null;
                
                public Child(boolean available, @org.jetbrains.annotations.NotNull()
                java.util.List<? extends java.lang.Object> childs, int count, @org.jetbrains.annotations.NotNull()
                java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child.ExtraInfo> extraInfo, @org.jetbrains.annotations.NotNull()
                java.lang.String id, @org.jetbrains.annotations.NotNull()
                java.lang.String menuRelation, @org.jetbrains.annotations.NotNull()
                java.lang.String plu, double price, @org.jetbrains.annotations.NotNull()
                java.lang.String title) {
                    super();
                }
                
                public final boolean getAvailable() {
                    return false;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.util.List<java.lang.Object> getChilds() {
                    return null;
                }
                
                public final int getCount() {
                    return 0;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.util.List<com.app.airmenu.models.OrderResponseAirMenu.Orders.UK.Child.ExtraInfo> getExtraInfo() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getId() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getMenuRelation() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPlu() {
                    return null;
                }
                
                public final double getPrice() {
                    return 0.0;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getTitle() {
                    return null;
                }
                
                @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$Child$ExtraInfo;", "", "desc", "", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "app_debug"})
                public static final class ExtraInfo {
                    @org.jetbrains.annotations.NotNull()
                    @com.google.gson.annotations.SerializedName(value = "desc")
                    private final java.lang.String desc = null;
                    
                    public ExtraInfo(@org.jetbrains.annotations.NotNull()
                    java.lang.String desc) {
                        super();
                    }
                    
                    @org.jetbrains.annotations.NotNull()
                    public final java.lang.String getDesc() {
                        return null;
                    }
                }
            }
            
            @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\u0018\u00002\u00020\u0001B\u00cd\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001e\u00a8\u00067"}, d2 = {"Lcom/app/airmenu/models/OrderResponseAirMenu$Orders$UK$ExtraInfo;", "", "aDDRESS", "", "address", "cAPACITY", "city", "complement", "date", "iTEMAVAILABILITY", "latitude", "longitude", "mISSINGINFO", "mISSINGITEM", "number", "oTHER", "pOSNOTREADY", "pOSOFFLINE", "pRICING", "phone", "phone2", "postalCode", "referencePoint", "sPECIALINSTRUCTIONS", "sTORECLOSED", "time", "timezone", "uK", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getADDRESS", "()Ljava/lang/String;", "getAddress", "getCAPACITY", "getCity", "getComplement", "getDate", "getITEMAVAILABILITY", "getLatitude", "getLongitude", "getMISSINGINFO", "getMISSINGITEM", "getNumber", "getOTHER", "getPOSNOTREADY", "getPOSOFFLINE", "getPRICING", "getPhone", "getPhone2", "getPostalCode", "getReferencePoint", "getSPECIALINSTRUCTIONS", "getSTORECLOSED", "getTime", "getTimezone", "getUK", "app_debug"})
            public static final class ExtraInfo {
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "ADDRESS")
                private final java.lang.String aDDRESS = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "address")
                private final java.lang.String address = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "CAPACITY")
                private final java.lang.String cAPACITY = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "city")
                private final java.lang.String city = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "complement")
                private final java.lang.String complement = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "date")
                private final java.lang.String date = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "ITEM_AVAILABILITY")
                private final java.lang.String iTEMAVAILABILITY = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "latitude")
                private final java.lang.String latitude = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "longitude")
                private final java.lang.String longitude = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "MISSING_INFO")
                private final java.lang.String mISSINGINFO = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "MISSING_ITEM")
                private final java.lang.String mISSINGITEM = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "number")
                private final java.lang.String number = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "OTHER")
                private final java.lang.String oTHER = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "POS_NOT_READY")
                private final java.lang.String pOSNOTREADY = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "POS_OFFLINE")
                private final java.lang.String pOSOFFLINE = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "PRICING")
                private final java.lang.String pRICING = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "phone")
                private final java.lang.String phone = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "phone2")
                private final java.lang.String phone2 = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "postalCode")
                private final java.lang.String postalCode = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "referencePoint")
                private final java.lang.String referencePoint = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "SPECIAL_INSTRUCTIONS")
                private final java.lang.String sPECIALINSTRUCTIONS = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "STORE_CLOSED")
                private final java.lang.String sTORECLOSED = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "time")
                private final java.lang.String time = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "timezone")
                private final java.lang.String timezone = null;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.SerializedName(value = "UK")
                private final java.lang.String uK = null;
                
                public ExtraInfo(@org.jetbrains.annotations.NotNull()
                java.lang.String aDDRESS, @org.jetbrains.annotations.NotNull()
                java.lang.String address, @org.jetbrains.annotations.NotNull()
                java.lang.String cAPACITY, @org.jetbrains.annotations.NotNull()
                java.lang.String city, @org.jetbrains.annotations.NotNull()
                java.lang.String complement, @org.jetbrains.annotations.NotNull()
                java.lang.String date, @org.jetbrains.annotations.NotNull()
                java.lang.String iTEMAVAILABILITY, @org.jetbrains.annotations.NotNull()
                java.lang.String latitude, @org.jetbrains.annotations.NotNull()
                java.lang.String longitude, @org.jetbrains.annotations.NotNull()
                java.lang.String mISSINGINFO, @org.jetbrains.annotations.NotNull()
                java.lang.String mISSINGITEM, @org.jetbrains.annotations.NotNull()
                java.lang.String number, @org.jetbrains.annotations.NotNull()
                java.lang.String oTHER, @org.jetbrains.annotations.NotNull()
                java.lang.String pOSNOTREADY, @org.jetbrains.annotations.NotNull()
                java.lang.String pOSOFFLINE, @org.jetbrains.annotations.NotNull()
                java.lang.String pRICING, @org.jetbrains.annotations.NotNull()
                java.lang.String phone, @org.jetbrains.annotations.NotNull()
                java.lang.String phone2, @org.jetbrains.annotations.NotNull()
                java.lang.String postalCode, @org.jetbrains.annotations.NotNull()
                java.lang.String referencePoint, @org.jetbrains.annotations.NotNull()
                java.lang.String sPECIALINSTRUCTIONS, @org.jetbrains.annotations.NotNull()
                java.lang.String sTORECLOSED, @org.jetbrains.annotations.NotNull()
                java.lang.String time, @org.jetbrains.annotations.NotNull()
                java.lang.String timezone, @org.jetbrains.annotations.NotNull()
                java.lang.String uK) {
                    super();
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getADDRESS() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getAddress() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getCAPACITY() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getCity() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getComplement() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getDate() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getITEMAVAILABILITY() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getLatitude() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getLongitude() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getMISSINGINFO() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getMISSINGITEM() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getNumber() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getOTHER() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPOSNOTREADY() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPOSOFFLINE() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPRICING() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPhone() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPhone2() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPostalCode() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getReferencePoint() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getSPECIALINSTRUCTIONS() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getSTORECLOSED() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getTime() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getTimezone() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getUK() {
                    return null;
                }
            }
        }
    }
}