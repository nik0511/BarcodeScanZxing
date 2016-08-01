package com.algofocus.barcodescanzxing.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.algofocus.barcodescanzxing.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseViewer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_viewer);
        DatabaseHandler db = new DatabaseHandler(this);
        List<String> list;
        list = db.showData();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) list);

    }
}
