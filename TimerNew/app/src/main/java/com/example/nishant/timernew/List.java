package com.example.nishant.timernew;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView listView ;
    ArrayList<String> data ;
    Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView)findViewById(R.id.list);
        timerlist();
    }
    void timerlist() {

        data = new ArrayList<String>();

        try {

            SQLiteDatabase db = this.openOrCreateDatabase("timing", MODE_PRIVATE, null);
            Cursor c = db.rawQuery("Select * from data", null);
            c.moveToFirst();

            int time = c.getColumnIndex("TIME");
            int date = c.getColumnIndex("DATE");
            int name = c.getColumnIndex("NAME");

            while (c != null) {

                data.add("\n\n" + c.getString(date) + "  " + c.getString(name) + "  " + c.getString(time));
                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

            listView.setAdapter((ListAdapter) adapter);
        }
    }
}
