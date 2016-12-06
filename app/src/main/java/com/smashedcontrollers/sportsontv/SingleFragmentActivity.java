package com.smashedcontrollers.sportsontv;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import static com.google.android.gms.internal.zzng.fm;
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fManager = getSupportFragmentManager();
        Fragment fragment = fManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}
