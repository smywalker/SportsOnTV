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
        footballTeam.add("Burger");
        footballTeam.add("Cheese Burger");
        footballTeam.add("Chicken Burger");
        footballTeam.add("Beef and Onion Pie");
        footballTeam.add("Pukka Pie");
        footballTeam.add("Tea");
        footballTeam.add("Coffie");
        footballTeam.add("Mars bar");
        footballTeam.add("Small chips");
        footballTeam.add("Large chips");
        footballTeam.add("Pie and chips");
        footballTeam.add("Pie and mash");
        footballTeam.add("Fish and chips");
        footballTeam.add("Donor kebab");
        footballTeam.add("Chicken Kebab");
        footballTeam.add("Sunderland");
        footballTeam.add("Kids meal (Burger)");
        footballTeam.add("Kids meal (Chicken Nuggets)");
        footballTeam.add("Panda pop");
        footballTeam.add("Can coke");
        //link data adapter
        RecyclerView.Adapter adapter = new DataAdapter(footballTeam);
        newRecyclerView.setAdapter(adapter);
    }
}