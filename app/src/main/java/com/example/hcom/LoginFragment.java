package com.example.hcom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hcom.databinding.FragmentLoginBinding;
import com.example.hcom.viewmodels.RegistrationViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private RegistrationViewModel registrationViewModel;

    public LoginFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater);
        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);
        binding.logInBtn.setOnClickListener(view -> {
            final String email = binding.emailET.getText().toString();
            final String password = binding.passwordET.getText().toString();
            registrationViewModel.login(email, password);
        });

        registrationViewModel.getStateLiveData().observe(getViewLifecycleOwner(), authState -> {
            if(authState == RegistrationViewModel.AuthState.AUTHENTICATED){
                Navigation.findNavController(container).navigate(R.id.action_loginFragment_to_homeFragment);
            }
        });

        registrationViewModel.getErrLiveData().observe(getViewLifecycleOwner(), errMessage -> {
            binding.errorET.setText(errMessage);
        });

        return binding.getRoot();
    }
}