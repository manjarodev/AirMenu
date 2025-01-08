package com.app.airmenu.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\'\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\"\u000e\u0010?\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"ACTION_CREATE_USER", "", "ACTION_DIVISION_IDS", "ACTION_GET_ORDERS", "ACTION_LOCATION_DIVISION_ENTERPRISES", "ACTION_LOGIN", "ACTION_NEW_ORDER", "ACTION_NOTIFICATION_ACCESS", "ACTION_POS_IDS", "ACTION_SAVE_MENU", "ACTION_SEND_ORDER", "ACTION_SERVICE_DESTROYED", "ACTION_UPDATE_FLAGS", "DIVISION_BY_CUSTOMER_ADDRESS", "ERROR_NAME", "ERROR_SESSION_EXPIRED", "ERROR_USER_ALREADY_EXISTS", "GRANT_TYPE", "KEY_BOOKING_TIME", "KEY_CHHILD_PLU_LIST", "KEY_CLIENT_ID", "KEY_CLIENT_SECRET", "KEY_DIVISION", "KEY_DIVISION_ID", "KEY_ENTERPRISE_ID", "KEY_GRANT_TYPE", "KEY_PLU_LIST", "KEY_POS_ID", "KEY_SCOPE", "KEY_SESSION_ID", "KEY_USERNAME", "KEY_USER_NAME", "KEY_USER_PASSWORD", "OAUTH_URL", "PLACES_API_KEY", "PREF_KEY_DIVISION_ID", "PREF_KEY_DIVISION_ID_Menu", "PREF_KEY_DIVISION_ID_RESPONSE", "PREF_KEY_DIVISION_NAME", "PREF_KEY_DIVISION_NAME_Menu", "PREF_KEY_ENTERPRISE_ID", "PREF_KEY_ENTERPRISE_NAME", "PREF_KEY_IS_SERVICE_RUNNING", "PREF_KEY_LOGIN_RESPONSE", "PREF_KEY_NOTIFICATION_RESPONSE", "PREF_KEY_NOTIFICATION_TOKEN", "PREF_KEY_POSTOKEN_RESPONSE", "PREF_KEY_POS_ID", "PREF_KEY_POS_ID_RESPONSE", "PREF_KEY_SELECTED_STORE", "PREF_KEY_SELECTED_STORE_DETAILS", "PREF_KEY_SESSION_ID", "PREF_KEY_SHOULD_STOP_SERVICE", "PREF_KEY_USER_EMAIL", "PREF_KEY_USER_PASSWORD", "PROPERTY", "REDIRECT_URI", "REMOTE_REPO", "Lcom/app/airmenu/remote/RemoteRepository;", "getREMOTE_REPO", "()Lcom/app/airmenu/remote/RemoteRepository;", "setREMOTE_REPO", "(Lcom/app/airmenu/remote/RemoteRepository;)V", "SCOPE_EATS_ORDER", "SCOPE_EATS_ORDER_DELIVERY_STATUS", "SCOPE_EATS_STORE", "SCOPE_EATS_STORE_ORDER_READ", "SCOPE_EATS_STORE_STATUS_WRITE", "STATUS_CODE", "STATUS_ERROR", "STATUS_SUCCESS", "UBER_AUTH_URL", "UBER_CLIENT_ID", "UBER_CLIENT_SECRET", "UBER_NEW_USER_PASSWORD", "cipher_text", "nif_decode_url", "serverKey", "app_debug"})
public final class ConstantsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PLACES_API_KEY = "AIzaSyADWEVs89NTvfpImSyvkYPLMoDR9fYTQHs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String serverKey = "3oTDTIwpYUlf23OhwZXVtmGLEWLlWFB65Esbu5comel7Pd0j53GFdCTMowb80eth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_POS_IDS = "GetEnterprisePosIds";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_DIVISION_IDS = "GetEnterpriseDivisionIds";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_LOGIN = "Authenticate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CREATE_USER = "CreateUser";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SEND_ORDER = "SendOrder";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SAVE_MENU = "SaveMenu";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_UPDATE_FLAGS = "ActivateFlag";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_NOTIFICATION_ACCESS = "GetNotificationAccess";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_LOCATION_DIVISION_ENTERPRISES = "GetLocationDivisionEnterprises";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_GET_ORDERS = "GetOrders";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_SUCCESS = "SUCCESS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_ERROR = "ERROR";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_NAME = "username";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USER_PASSWORD = "password";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_SESSION_ID = "sessionId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_ENTERPRISE_ID = "enterpriseId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DIVISION = "division";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_POS_ID = "POSId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DIVISION_ID = "divisionId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_BOOKING_TIME = "bookingTime";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USERNAME = "username";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_PLU_LIST = "pluList";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_CHHILD_PLU_LIST = "childPluList";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_SESSION_ID = "keySessionId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_LOGIN_RESPONSE = "keyLoginResponse";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_POS_ID_RESPONSE = "keyPOSIdResponse";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_DIVISION_ID_RESPONSE = "keyDivisionIdResponse";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_ENTERPRISE_ID = "keyEnterpriseId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_ENTERPRISE_NAME = "keyEnterpriseName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_POS_ID = "keyPOSId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_DIVISION_ID = "keyDivisionId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_DIVISION_ID_Menu = "keyDivisionIdMenu";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_DIVISION_NAME = "keyDivisionName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_DIVISION_NAME_Menu = "keyDivisionNameMenu";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_USER_EMAIL = "keyUserEmail";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_USER_PASSWORD = "keyUserPassword";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_NOTIFICATION_RESPONSE = "keyNotificationResponse";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_POSTOKEN_RESPONSE = "keyPOSTokenResponse";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_SELECTED_STORE = "keySeletedStore";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_SELECTED_STORE_DETAILS = "keySeletedStoreDetails";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_NOTIFICATION_TOKEN = "keyNotificationToken";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_SHOULD_STOP_SERVICE = "keyShouldStopService";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_KEY_IS_SERVICE_RUNNING = "isServiceRunning";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SERVICE_DESTROYED = "com.app.airmenu.SERVICE_DESTROYED";
    @org.jetbrains.annotations.Nullable()
    private static com.app.airmenu.remote.RemoteRepository REMOTE_REPO;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCOPE_EATS_ORDER = "eats.order";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCOPE_EATS_STORE_ORDER_READ = "eats.store.orders.read";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCOPE_EATS_STORE = "eats.store";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCOPE_EATS_STORE_STATUS_WRITE = "eats.store.status.write";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCOPE_EATS_ORDER_DELIVERY_STATUS = "eats.store.orders.restaurantdelivery.status";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UBER_CLIENT_SECRET = "1l5mnMGHuk0YVbMOVUh1arfwyxLJFcdh26pgvfKO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UBER_CLIENT_ID = "ISOkRlMQwg38CufEUItAKBLGeFk8H8Mi";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GRANT_TYPE = "client_credentials";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UBER_AUTH_URL = "https://login.uber.com/oauth/v2/token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UBER_NEW_USER_PASSWORD = "!!NOPASSWORD!!";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DIVISION_BY_CUSTOMER_ADDRESS = "divisionByCustomerAddress";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REDIRECT_URI = "https://info.airmenu.com/en";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OAUTH_URL = "https://login.uber.com/oauth/v2/authorize?response_type=code&scope=eats.pos_provisioning&client_id=ISOkRlMQwg38CufEUItAKBLGeFk8H8Mi&redirect_uri=https://info.airmenu.com/en";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_SCOPE = "scope";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_GRANT_TYPE = "grant_type";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_CLIENT_SECRET = "client_secret";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_CLIENT_ID = "client_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_NEW_ORDER = "new_uber_order";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERROR_USER_ALREADY_EXISTS = "USER_ALREADY_EXIST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERROR_SESSION_EXPIRED = "INVALID_SESSION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_CODE = "statusCode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERROR_NAME = "errorName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROPERTY = "property";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String cipher_text = "Jru6J3sL3z5PE4b+wL9HEq/AqZVKPfOd0eBMyD1GpgKpR71rsp6K";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String nif_decode_url = "https://us-central1-airmenu-connector.cloudfunctions.net/getNif.js";
    
    @org.jetbrains.annotations.Nullable()
    public static final com.app.airmenu.remote.RemoteRepository getREMOTE_REPO() {
        return null;
    }
    
    public static final void setREMOTE_REPO(@org.jetbrains.annotations.Nullable()
    com.app.airmenu.remote.RemoteRepository p0) {
    }
}