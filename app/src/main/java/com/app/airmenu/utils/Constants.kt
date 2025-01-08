package com.app.airmenu.utils

import com.app.airmenu.remote.RemoteRepository

enum class RequestState {
    DONE, LOADING, ERROR, SESSION_EXPIRED
}

enum class SocketState {
    CONNECTING, CONNECTED, DISCONNECTED
}

enum class RestaurantStatus {
    ONLINE, PAUSED, OFFLINE
}

enum class ActiveFlags {
    ACCEPT, DENY, CANCEL, STARTED, ARRIVING, DELIVERED
}

const val PLACES_API_KEY = "AIzaSyADWEVs89NTvfpImSyvkYPLMoDR9fYTQHs"

//const val serverKey = "OEFKf6I5qJjrW3ArYZxtjfGEb9x49QsAP9bksWj4cX1zQ5rwQSlr4oVhXB8WnUv2"
const val serverKey = "3oTDTIwpYUlf23OhwZXVtmGLEWLlWFB65Esbu5comel7Pd0j53GFdCTMowb80eth"
const val ACTION_POS_IDS = "GetEnterprisePosIds"
const val ACTION_DIVISION_IDS = "GetEnterpriseDivisionIds"
const val ACTION_LOGIN = "Authenticate"
const val ACTION_CREATE_USER = "CreateUser"
const val ACTION_SEND_ORDER = "SendOrder"
const val ACTION_SAVE_MENU = "SaveMenu"
const val ACTION_UPDATE_FLAGS = "ActivateFlag"
const val ACTION_NOTIFICATION_ACCESS = "GetNotificationAccess"
const val ACTION_LOCATION_DIVISION_ENTERPRISES = "GetLocationDivisionEnterprises"
const val ACTION_GET_ORDERS = "GetOrders"
const val STATUS_SUCCESS = "SUCCESS"
const val STATUS_ERROR = "ERROR"

const val KEY_USER_NAME = "username"
const val KEY_USER_PASSWORD = "password"
const val KEY_SESSION_ID = "sessionId"
const val KEY_ENTERPRISE_ID = "enterpriseId"
const val KEY_DIVISION = "division"
const val KEY_POS_ID = "POSId"
const val KEY_DIVISION_ID = "divisionId"
const val KEY_BOOKING_TIME = "bookingTime"
const val KEY_USERNAME = "username"
const val KEY_PLU_LIST = "pluList"
const val KEY_CHHILD_PLU_LIST = "childPluList"

const val PREF_KEY_SESSION_ID = "keySessionId"
const val PREF_KEY_LOGIN_RESPONSE = "keyLoginResponse"
const val PREF_KEY_POS_ID_RESPONSE = "keyPOSIdResponse"
const val PREF_KEY_DIVISION_ID_RESPONSE = "keyDivisionIdResponse"
const val PREF_KEY_ENTERPRISE_ID = "keyEnterpriseId"
const val PREF_KEY_ENTERPRISE_NAME = "keyEnterpriseName"
const val PREF_KEY_POS_ID = "keyPOSId"
const val PREF_KEY_DIVISION_ID = "keyDivisionId"
const val PREF_KEY_DIVISION_ID_Menu = "keyDivisionIdMenu"
const val PREF_KEY_DIVISION_NAME = "keyDivisionName"
const val PREF_KEY_DIVISION_NAME_Menu = "keyDivisionNameMenu"
const val PREF_KEY_USER_EMAIL = "keyUserEmail"
const val PREF_KEY_USER_PASSWORD = "keyUserPassword"
const val PREF_KEY_NOTIFICATION_RESPONSE = "keyNotificationResponse"
const val PREF_KEY_POSTOKEN_RESPONSE = "keyPOSTokenResponse"
const val PREF_KEY_SELECTED_STORE = "keySeletedStore"
const val PREF_KEY_SELECTED_STORE_DETAILS = "keySeletedStoreDetails"
const val PREF_KEY_NOTIFICATION_TOKEN = "keyNotificationToken"
const val PREF_KEY_SHOULD_STOP_SERVICE = "keyShouldStopService"
const val PREF_KEY_IS_SERVICE_RUNNING = "isServiceRunning"

const val ACTION_SERVICE_DESTROYED = "com.app.airmenu.SERVICE_DESTROYED"

var REMOTE_REPO: RemoteRepository? = null

// Uber order scopes
const val SCOPE_EATS_ORDER = "eats.order"
const val SCOPE_EATS_STORE_ORDER_READ = "eats.store.orders.read"
const val SCOPE_EATS_STORE = "eats.store"
const val SCOPE_EATS_STORE_STATUS_WRITE = "eats.store.status.write"
const val SCOPE_EATS_ORDER_DELIVERY_STATUS = "eats.store.orders.restaurantdelivery.status"

//Uber test Credentials
const val UBER_CLIENT_SECRET = "1l5mnMGHuk0YVbMOVUh1arfwyxLJFcdh26pgvfKO"
const val UBER_CLIENT_ID = "ISOkRlMQwg38CufEUItAKBLGeFk8H8Mi"
////
// Uber production Credentials
//const val UBER_CLIENT_SECRET = "8RdJJCbh2Dpx_eHiuzVrLdDi717Niht3hXp45Sa0"
//const val UBER_CLIENT_ID = "QSiZVQZ4nZLikGXKNq6bdYcY7esYtYtv"

const val GRANT_TYPE = "client_credentials"
const val UBER_AUTH_URL = "https://login.uber.com/oauth/v2/token"
const val UBER_NEW_USER_PASSWORD = "!!NOPASSWORD!!"
const val DIVISION_BY_CUSTOMER_ADDRESS = "divisionByCustomerAddress"
const val REDIRECT_URI = "https://info.airmenu.com/en"
const val OAUTH_URL =
    "https://login.uber.com/oauth/v2/authorize?response_type=code&scope=eats.pos_provisioning&client_id=$UBER_CLIENT_ID&redirect_uri=$REDIRECT_URI"

//Uber REQUEST KEYS
const val KEY_SCOPE = "scope"
const val KEY_GRANT_TYPE = "grant_type"
const val KEY_CLIENT_SECRET = "client_secret"
const val KEY_CLIENT_ID = "client_id"

//Broadcast ACTION
const val ACTION_NEW_ORDER = "new_uber_order"


// Airmenu Error names
const val ERROR_USER_ALREADY_EXISTS = "USER_ALREADY_EXIST"
const val ERROR_SESSION_EXPIRED = "INVALID_SESSION"

// Airmenu response keys
const val STATUS_CODE = "statusCode"
const val ERROR_NAME = "errorName"
const val PROPERTY = "property"


// NIF Tax ID
const val cipher_text = "Jru6J3sL3z5PE4b+wL9HEq/AqZVKPfOd0eBMyD1GpgKpR71rsp6K"

const val nif_decode_url = "https://us-central1-airmenu-connector.cloudfunctions.net/getNif.js"


