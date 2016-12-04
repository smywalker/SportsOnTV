package com.smashedcontrollers.sportsontv;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //constants
    private static int RC_SIGN_IN = 0;
    private static  String TAG = "MAIN_ACTIVITY";

    //variables
    private GoogleApiClient mGoogleApiClient;//how we are going to connect to google
    private FirebaseAuth mAuth;// how to authenticate to firebase
    private FirebaseAuth.AuthStateListener mAuthListener;//listens for changes in the authentication
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //see auth status when create an activity
        mAuth = FirebaseAuth.getInstance();
        //set up listener to see when we log in and out
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                // check to see if user is there
                if(user != null){
                    Log.d("AUTH", "user logged in" + user.getEmail());

                }else{
                    Log.d("AUTH", "user logged out.");
                }
            }
        };
        //used to sign in, what we want to receive back from google
        //aswell as how we want to send our requests
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
    }
}
