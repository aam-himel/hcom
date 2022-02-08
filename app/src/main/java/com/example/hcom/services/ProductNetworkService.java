package com.example.hcom.services;

import com.example.hcom.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ProductNetworkService {

    public static ProductServiceAPI getProductService(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.PRODUCT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ProductServiceAPI.class);
    }
}
