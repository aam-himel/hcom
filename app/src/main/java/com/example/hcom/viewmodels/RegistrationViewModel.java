package com.example.hcom.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationViewModel extends ViewModel {

    public enum AuthState {
        AUTHENTICATED, UNAUTHENTICATED
    }

    private MutableLiveData<AuthState> stateLiveData;
    private MutableLiveData<String>  errLiveData;
    private FirebaseAuth auth;
    private FirebaseUser user;

    public MutableLiveData<AuthState> getStateLiveData() {
        return stateLiveData;
    }

    public MutableLiveData<String> getErrLiveData() {
        return errLiveData;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public RegistrationViewModel() {
        stateLiveData = new MutableLiveData<>();
        errLiveData = new MutableLiveData<>();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user == null){
            stateLiveData.postValue(AuthState.UNAUTHENTICATED);
        }else {
            stateLiveData.postValue(AuthState.AUTHENTICATED);
        }
    }

    public void login(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            user = authResult.getUser();
            stateLiveData.postValue(AuthState.AUTHENTICATED);
            Log.d("Auth", "signInWithEmail:success\n"+user);

        }).addOnFailureListener(e -> {
            errLiveData.postValue(e.getLocalizedMessage());
            Log.d("Auth", "signInWithEmail:failed\n"+e.getLocalizedMessage());

        });
    }
}
