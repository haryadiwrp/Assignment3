package com.hacktiv8.assignment3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private ApiService apiService;

    public RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiService.BASE_URL_1).
                addConverterFactory(GsonConverterFactory.create()).build();

        apiService = retrofit.create(ApiService.class);

    }

    public static synchronized  RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }

        return instance;
    }

    public  ApiService apiService(){
        return apiService;
    }
}
