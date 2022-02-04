package com.example.hcom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hcom.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public LoginFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater);

        binding.loginBtn.setOnClickListener(view -> {
            final String email = binding.emailET.getText().toString();
            final String password = binding.passwordET.getText().toString();
            Toast.makeText(getActivity(), ""+ email+", "+password, Toast.LENGTH_SHORT).show();
        });



        return binding.getRoot();
    }
}