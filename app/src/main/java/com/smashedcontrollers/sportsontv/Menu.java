package com.smashedcontrollers.sportsontv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    private static ImageButton ballButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    //onclick method to to
    public void onButtonClick(View view){
        switch (view.getId()) {
            case R.id.ballImageButton:

                break;
            case R.id.basketBallButton:
                break;
            case R.id.musicButton:
                break;
            case R.id.yubeButton:
                break;
            case R.id.pictureButton:
                Intent ballIntent = new Intent(".Gallery");
                startActivity(ballIntent);
                break;
            case R.id.feedbackButton:
                break;
            default:
                break;

        }
    }

}
