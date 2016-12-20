package com.example.bebe.databasestore;

/**
 * Created by Bebe on 12/1/2016.
 */

public final class DataSet {

    DataSet (){}

    public static abstract class DataEntry
    {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String QUANTITY = "quantity";
        public static final String PRICE = "price";
        public static final String TABLE_NAME = "item_table";

    }
}
