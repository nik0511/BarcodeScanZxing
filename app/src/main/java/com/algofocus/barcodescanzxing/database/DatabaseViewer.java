package com.algofocus.barcodescanzxing.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        List<String> list = new ArrayList<String>();
        list = db.showData();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(ad);

    }
}
