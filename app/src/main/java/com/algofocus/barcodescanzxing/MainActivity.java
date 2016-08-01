package com.algofocus.barcodescanzxing;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.algofocus.barcodescanzxing.database.DatabaseHandler;
import com.algofocus.barcodescanzxing.database.DatabaseViewer;
import com.algofocus.barcodescanzxing.database.QReader;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button scanQr;
    private Button addData;
    private Button showData;
    private TextView textViewInfo;
    private String qr_info = "demo";
    private static int id =101010;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanQr = (Button) findViewById(R.id.scanButton);
        scanQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanQrCode();
            }
        });
        addData = (Button) findViewById(R.id.add_database);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();
            }
        });
        showData = (Button) findViewById(R.id.show_database);
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatabase();
            }
        });
    }

    public void scanQrCode(){

        try {
            Intent scan = new Intent("com.google.zxing.client.android.SCAN");
            scan.putExtra("SCAN_MODE", "QR_CODE");
            startActivityForResult(scan, 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            if(resultCode== RESULT_OK){
                textViewInfo = (TextView) findViewById(R.id.scan_info);
               // textViewInfo.setText(data.getDataString());
                qr_info = data.getStringExtra("SCAN_RESULT");
                textViewInfo.setText(qr_info);

            }
        }
    }

    public void addToDatabase(){

        DatabaseHandler db  = new DatabaseHandler(this);
        db.addData(new QReader(id,qr_info));
        Random random = new Random();
        id = random.nextInt(100000);
        /*Toast toast = new Toast(getApplicationContext());
        toast.makeText(this,"Added",Toast.LENGTH_LONG);
        toast.show();*/
        Toast.makeText(this,"added",Toast.LENGTH_LONG).show();


    }
    public void showDatabase(){
        Intent intent = new Intent(getApplicationContext(), DatabaseViewer.class);
        startActivity(intent);
    }
}
