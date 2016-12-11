package com.smashedcontrollers.sportsontv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Basketball extends AppCompatActivity {
    //declared variables
    DatabaseReference newDatabaseRef;
    ListView newListView;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
        newListView=(ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.
        simple_dropdown_item_1line, list);
        newListView.setAdapter(adapter);
        newDatabaseRef =FirebaseDatabase.getInstance().getReference();
        newDatabaseRef.addChildEventListener(new ChildEventListener() {
            //When we add entry in the cloud it is added to the listview
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                list.add(value);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            //when we remove an entry in the cloud, this makes sure it removes entry in the listview
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                list.remove(value);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue(" dave beckham");
    }


}
