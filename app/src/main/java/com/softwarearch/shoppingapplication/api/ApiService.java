package com.softwarearch.shoppingapplication.api;

import com.softwarearch.shoppingapplication.models.reponse_models.LoginResponseModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Observable<LoginResponseModel> getLoginResponse(
            @Field("username") String username,
            @Field("password") String password);
}
