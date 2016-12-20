package com.example.bebe.databasestore;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bebe on 12/2/2016.
 */

public class ItemAdapter extends ArrayAdapter {

    List list = new ArrayList();


    public ItemAdapter(Context context, int resource)
    {
        super(context, resource);
    }


    public void add(Item object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return (long) list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemHolder itemHolder;
        if(row ==null){

            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.display_item_row,parent,false);
            itemHolder = new ItemHolder();
            itemHolder.tx_id = (TextView)row.findViewById(R.id.d_id);
            itemHolder.tx_name = (TextView)row.findViewById(R.id.d_name);
            itemHolder.tx_quantity = (TextView)row.findViewById(R.id.d_quantity);
            itemHolder.tx_price = (TextView)row.findViewById(R.id.d_price);

            row.setTag(itemHolder);
        }
        else {
            itemHolder =(ItemHolder) row.getTag();
        }
        Item  item = (Item) getItem(position);
        itemHolder.tx_id.setText(item.getId().toString());
        itemHolder.tx_name.setText(item.getName().toString());
        itemHolder.tx_quantity.setText(Integer.toString(item.getQuantity()));
        itemHolder.tx_price.setText(Integer.toString(item.getPrice()));


        return row;
    }

    static class ItemHolder {

        TextView tx_id,tx_name,tx_quantity,tx_price;

    }

}
