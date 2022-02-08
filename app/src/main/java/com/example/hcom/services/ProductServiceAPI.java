package com.example.hcom.services;

import com.example.hcom.models.ProductModel;
import com.example.hcom.models.ProductModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductServiceAPI {

    @GET("/products")
    Call<List<ProductModelItem>> getAllProducts();
}
