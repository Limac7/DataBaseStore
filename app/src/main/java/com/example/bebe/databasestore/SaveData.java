package com.example.bebe.databasestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveData extends AppCompatActivity {
    EditText et_id,et_name,et_quantity,et_price;
    String id,name,quantity,price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        et_id = (EditText)findViewById(R.id.the_id);
        et_name = (EditText)findViewById(R.id.the_name);
        et_quantity = (EditText)findViewById(R.id.the_quantity);
        et_price= (EditText)findViewById(R.id.the_price);

    }
    public void saveData(View view){

        id = et_id.getText().toString();
        name = et_name.getText().toString();
        quantity = et_quantity.getText().toString();
        price = et_price.getText().toString();

        BackgroundWork backgroundWork = new BackgroundWork(this);
        backgroundWork.execute("add_item",id,name,quantity,price);
        finish();



    }
}
