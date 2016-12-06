package com.smashedcontrollers.sportsontv;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {

    //Global variables
    LoginButton loginButton;
    CallbackManager callbackManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //set orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Facebook login
        //Link FB login button
        loginButton = (LoginButton)findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            //If the login successful
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent loginIntent = new Intent(MainActivity.this,Menu.class);
                startActivity(loginIntent);
                Toast successToast = Toast.makeText(MainActivity.this ,"Welcome", Toast.LENGTH_LONG);
                successToast.show();
            }
            //The the user cancels the signin process
            @Override
            public void onCancel() {
                Toast cancelToast = Toast.makeText(MainActivity.this ,"Sign in Cancelled", Toast.LENGTH_SHORT);
                cancelToast.show();
            }
            //If there is an error when signing in
            @Override
            public void onError(FacebookException error) {
                Toast errorToast = Toast.makeText(MainActivity.this ,"Welcome", Toast.LENGTH_LONG);
                errorToast.show();
            }
        });
    }
    //Facebook API code for login
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode, data);
    }

}
