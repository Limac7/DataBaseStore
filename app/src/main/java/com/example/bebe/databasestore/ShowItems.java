package com.example.bebe.databasestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShowItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_items_layout);
        BackgroundWork backgroundWork = new BackgroundWork(this);
            backgroundWork.execute("get_data");
    }
}
