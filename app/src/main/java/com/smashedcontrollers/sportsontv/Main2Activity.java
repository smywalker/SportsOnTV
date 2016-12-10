package com.smashedcontrollers.sportsontv;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //create instance of content value class

        insertNote("New note");
        //create object that has references to the data
        Cursor cursor = getContentResolver().query(NotesProvider.CONTENT_URI,
                DBOpenHelper.ALL_COLUMNS,null, null, null, null);

        String[] from = {DBOpenHelper.NOTE_TEXT};
        int[] to = {android.R.id.text1};
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, cursor, from,to, 0);

        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(cursorAdapter);

    }

    private void insertNote(String noteText) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI,values);
        Log.d("Main2Activity", "Inserted note" + noteUri.getLastPathSegment());
    }
}
