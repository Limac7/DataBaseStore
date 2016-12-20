package com.example.bebe.databasestore;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Bebe on 12/1/2016.
 */

public class BackgroundWork extends AsyncTask<String,Item,String> {

    Context context;
    ItemAdapter itemAdapter;
    Activity activity;
    ListView listView;


     BackgroundWork(Context context){
         this.context = context;
         activity = (Activity) context;
     }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... voids) {

        String method = voids[0];
        MyDBHandler myDBHandler = new MyDBHandler(context);

        if(method.equals("add_item")){
            String id = voids[1];
            String name = voids[2];
            int quantity = Integer.parseInt(voids[3]);
            int price = Integer.parseInt(voids[4]);

            SQLiteDatabase db = myDBHandler.getWritableDatabase();
            myDBHandler.addInfo(db,id,name,quantity,price);

            return "One Row Inserted";


        }
        else if (method.equals("get_data")){

            listView = (ListView) activity.findViewById(R.id.show_listview);

            SQLiteDatabase db = myDBHandler.getReadableDatabase();
            Cursor cursor = myDBHandler.getInfo(db);
            itemAdapter =  new ItemAdapter(context,R.layout.display_item_row);

            String id,name;
            int quantity,price;

            while(cursor.moveToNext()){
                id = cursor.getString(cursor.getColumnIndex(DataSet.DataEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(DataSet.DataEntry.NAME));
                quantity = cursor.getInt(cursor.getColumnIndex(DataSet.DataEntry.QUANTITY));
                price = cursor.getInt(cursor.getColumnIndex(DataSet.DataEntry.PRICE));

                Item item = new Item(id,name,quantity,price);

                publishProgress(item);

                return "get_data";

            }


        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Item... values) {

        itemAdapter.add(values[0]);


    }

    @Override
    protected void onPostExecute(String display) {

        if (display.equals("get_data")){
            listView.setAdapter(itemAdapter);
        }
        else {
            Toast.makeText(context, display, Toast.LENGTH_SHORT).show();
        }
    }
}
