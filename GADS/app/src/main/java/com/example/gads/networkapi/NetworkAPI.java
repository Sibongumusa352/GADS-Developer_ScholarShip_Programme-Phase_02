package com.example.gads.networkapi;

import androidx.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkAPI {


    public static final String get_BASE_URL="https://gadsapi.herokuapp.com/";

    public static Retrofit retro = null;

    public static Retrofit GET_Base_url(){

           HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

            retro = new Retrofit.Builder().baseUrl(get_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();

        return retro;
    }


}
