package com.example.hcom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hcom.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;

    public SignUpFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater);



        return binding.getRoot();
    }

    void registration() {
        final String firstName = binding.firstNameET.getText().toString();
        final String lastName = binding.lastNameET.getText().toString();
        final String email = binding.emailET.getText().toString();
        final String password = binding.passwordET.getText().toString();

    }
}