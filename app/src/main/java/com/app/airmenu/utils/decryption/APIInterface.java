package com.app.airmenu.utils.decryption;


import org.json.JSONObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

//    @Headers("Content-Type: application/json")
    @POST("getNif")
    Call<ResponseBody> decryptNif(
            @Body RequestBody jsonObject
    );
}
