package com.example.hcom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hcom.databinding.FragmentNewsFeedBinding;
import com.example.hcom.models.ProductModelItem;
import com.example.hcom.viewmodels.NewsFeedViewModel;

import java.util.List;

public class NewsFeedFragment extends Fragment {
    FragmentNewsFeedBinding binding;
    NewsFeedViewModel viewModel;

    public NewsFeedFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewsFeedBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(NewsFeedViewModel.class);

        viewModel.getProducts().observe(getViewLifecycleOwner(), productModelItems -> {
            Log.d("products", productModelItems.get(0).getTitle());
        });


        return binding.getRoot();
    }
}