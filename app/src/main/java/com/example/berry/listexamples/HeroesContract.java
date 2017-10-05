package com.example.berry.listexamples;

import android.provider.BaseColumns;

/**
 * Created by per6 on 10/3/17.
 */

public class HeroesContract {
    private HeroesContract() {
    }
    public static class HeroEntry implements BaseColumns{
        public static final String TABLE_NAME = "heroes";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_RESOURCE_ID = "resid";
    }

}
