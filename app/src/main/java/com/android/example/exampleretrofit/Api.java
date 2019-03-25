package com.android.example.exampleretrofit;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * In this step we create a new class to set the Retrofit.
 * In this class getClient method returns the Api Interface class object
 * which we are using in our MainActivity.
 */

public class Api {

    public static final String LOG_TAG = MainActivity.class.getName();

    private static String BASE_URL_GZ ="https://test.elementzone.uk/";
    private static Retrofit retrofit = null;

    public static ApiInterface getClient(){

        // change your base URL
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_GZ)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        Log.i(LOG_TAG, "connect method loader check point 3 " + BASE_URL_GZ);
        return api;
    }
}
