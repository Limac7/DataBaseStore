package com.example.bebe.databasestore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.Context;

/**
 * Created by Bebe on 12/1/2016.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "item_info.db";

    MyDBHandler( Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("DATABASE ACTIVITY", "DATABASE CREATED");



    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DataSet.DataEntry.TABLE_NAME + "(" +
                DataSet.DataEntry.ID + " TEXT," +
                DataSet.DataEntry.NAME + " TEXT," +
                DataSet.DataEntry.QUANTITY + " INTEGER," +
                DataSet.DataEntry.PRICE + " INTEGER" +
                ");";
        db.execSQL(query);
        Log.d("DATABASE ACTIVITY", "TABLE CREATED");

    }

    public void addInfo(SQLiteDatabase db, String id, String name, int quantity, int price) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataSet.DataEntry.ID,id);
        contentValues.put(DataSet.DataEntry.NAME,name);
        contentValues.put(DataSet.DataEntry.QUANTITY,quantity);
        contentValues.put(DataSet.DataEntry.PRICE,price);
        db.insert(DataSet.DataEntry.TABLE_NAME,null,contentValues);
        Log.d("DATABASE ACTIVITY", "ROW INSERTED");


    }

    public Cursor getInfo(SQLiteDatabase db){

        String [] projections = {DataSet.DataEntry.ID,DataSet.DataEntry.NAME,DataSet.DataEntry.QUANTITY,DataSet.DataEntry.PRICE};

        Cursor cursor = db.query(DataSet.DataEntry.TABLE_NAME,projections,null,null,null,null,null);

        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
