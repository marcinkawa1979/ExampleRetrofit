package com.android.example.exampleretrofit;

import com.android.example.exampleretrofit.POJO.SingUpResponse;
import com.android.example.exampleretrofit.POJO.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded // annotation used in POST type requests
    @POST("/retrofit/register.php") // API's endpoints
    Call<SingUpResponse> registration(@Field("username") String username,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("logintype") String loginType);

    // In registration method @Field used to set the keys
    // and String data type is representing its a string type value
    // and callback is used to get the response from api
    // and it will set it in our POJO class.

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("login")
    Call<User> logIn(@Field("email") String email,
                     @Field("password") String password);


}
