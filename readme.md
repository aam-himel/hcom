# Hcom

This is a practice project for learning Android using Java.


### ⚡ Features ⚡

- Beautiful UI
- Authentication using Firebase. 
- Login With Email and Password 
- SignUp using Email and Password.
- MVVM structure
- Api call using Retrofit and Display data into UI


## Authentication system

[ ] First create viewmodel
[ ] Create an enum type with two variable named AUTHENTICATED and UNAUTHENTICATED
[ ] create some MutableLiveData to hold the values of the stateLive data, errLiveData etc
[ ] create FirebaseAuth and FirebaseUser variable
[ ] getter for liveData and user
[ ] initialize all the variable declared earlier and check if the user is exists or not
  if not exists then postValue as UNAUTHENTICATED, otherwise postValue as AUTHENTICATED


```java
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
```

- now create two methods login and signUp and then set the value of live data and user after getting success result or set 
 errLiveData.
  
## External Libraries & Extra Features

[ ] Bottom Navigation
    - [Animated bottom navigation with different animation](https://github.com/Droppers/AnimatedBottomBar)
    - [Shimmer Animation like skeleton loading ....](https://github.com/facebook/shimmer-android)

