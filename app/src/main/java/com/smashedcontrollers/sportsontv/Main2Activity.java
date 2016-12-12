package com.smashedcontrollers.sportsontv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //create list of names
    private ArrayList footballTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //call method
        initViews();
    }
    private void initViews(){
        //link objects and add data
        RecyclerView newRecyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        newRecyclerView.setHasFixedSize(true);
        //set layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        newRecyclerView.setLayoutManager(layoutManager);
        footballTeam = new ArrayList<>();
        //add teams to list
        footballTeam.add("Arsenal");
        footballTeam.add("Boro");
        footballTeam.add("Manchester City");
        footballTeam.add("Bounemouth");
        footballTeam.add("Burnley");
        footballTeam.add("Chelsea");
        footballTeam.add("Everton");
        footballTeam.add("Hull");
        footballTeam.add("Leicester City");
        footballTeam.add("Liverpool");
        footballTeam.add("Manchester United");
        footballTeam.add("Crystal Palace");
        footballTeam.add("Southamptom");
        footballTeam.add("Totternam Hotspur");
        footballTeam.add("Stoke");
        footballTeam.add("Sunderland");
        footballTeam.add("Swansea");
        footballTeam.add("Watford");
        footballTeam.add("West Brom");
        footballTeam.add("West Ham");
        //link data adapter
        RecyclerView.Adapter adapter = new DataAdapter(footballTeam);
        newRecyclerView.setAdapter(adapter);
    }
}