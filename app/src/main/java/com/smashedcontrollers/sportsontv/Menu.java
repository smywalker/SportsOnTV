package com.smashedcontrollers.sportsontv;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onButtonClick(View view){
        Intent nIntent = new Intent(this, Menu.class);
        startActivity(nIntent);
        Toast notToast = Toast.makeText(MainActivity.this ,"Welcome", Toast.LENGTH_LONG);
        notToast.show();
    }


}
