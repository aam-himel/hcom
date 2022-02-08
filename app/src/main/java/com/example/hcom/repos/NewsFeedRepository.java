package com.example.hcom.repos;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hcom.models.ProductModel;
import com.example.hcom.models.ProductModelItem;
import com.example.hcom.services.ProductNetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedRepository {
    public LiveData<List<ProductModelItem>> getAllProducts(){
        MutableLiveData<List<ProductModelItem>> liveData = new MutableLiveData<>();
        ProductNetworkService.getProductService().getAllProducts().enqueue(new Callback<List<ProductModelItem>>() {
            @Override
            public void onResponse(Call<List<ProductModelItem>> call, Response<List<ProductModelItem>> response) {
                if(response.code() == 200){
                    final List<ProductModelItem> items = response.body();
                    Log.d("products", items.size()+" yeah!! api is called!!!! " + items.get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<ProductModelItem>> call, Throwable t) {
                Log.d("products", t.getMessage()+" Error is happening!!!");
            }
        });


        return liveData;
    }


}
