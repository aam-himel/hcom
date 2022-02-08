package com.example.hcom.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hcom.models.ProductModel;
import com.example.hcom.models.ProductModelItem;
import com.example.hcom.repos.NewsFeedRepository;

import java.util.List;

public class NewsFeedViewModel extends ViewModel {
    private NewsFeedRepository repository;

    public NewsFeedViewModel() {
        repository = new NewsFeedRepository();
    }
    public LiveData<List<ProductModelItem>> getProducts(){
        return repository.getAllProducts();
    }
}
