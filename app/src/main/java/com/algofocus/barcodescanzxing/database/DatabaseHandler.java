package com.algofocus.barcodescanzxing.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramon on 7/31/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

private static String CREATE_TABLE;
    private static final String DATABASE_NAME = "QR_Codes_Information";
    private static final String TABLE_NAME = "QR_Info";
    private static final String KEY_ID = "Id";
    private static final String KEY_INFO = " Info";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        CREATE_TABLE = "CREATE  TABLE " + TABLE_NAME + "( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_INFO + " TEXT " + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addData(QReader qReader){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,qReader.getId());
        values.put(KEY_INFO,qReader.getInfo());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }
    public List<String> showData(){
        List<String> list = new ArrayList<String>();
        QReader qReader = new QReader();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(cursor.moveToFirst()){
            do{


                list.add(cursor.getString(1));

            }while(cursor.moveToNext());
        }
        return list;

    }
}
