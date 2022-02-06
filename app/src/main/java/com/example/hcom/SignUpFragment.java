package com.example.hcom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hcom.databinding.FragmentSignUpBinding;
import com.example.hcom.viewmodels.RegistrationViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private RegistrationViewModel viewModel;

    public SignUpFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);

        binding.signUpBtn.setOnClickListener(view -> {
            registration();
        });

        viewModel.getStateLiveData().observe(getViewLifecycleOwner(), authState -> {
            if(authState == RegistrationViewModel.AuthState.AUTHENTICATED){
                Navigation.findNavController(container).navigate(R.id.action_signUpFragment_to_homeFragment);
            }
        });
        binding.loginLink.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_loginFragment);
        });

        return binding.getRoot();
    }

    void registration() {
        final String firstName = binding.firstNameET.getText().toString();
        final String lastName = binding.lastNameET.getText().toString();
        final String email = binding.emailET.getText().toString();
        final String password = binding.passwordET.getText().toString();
        viewModel.register(firstName, lastName, email, password);
    }
}