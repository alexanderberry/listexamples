package com.example.berry.listexamples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by per6 on 10/3/17.
 */

public class HeroesContract {
    private HeroesContract() {
    }
    public static class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "heroes";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_RESOURCE_ID = "resid";

        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                FeedEntry._ID + " INTEGER PRIMARY KEY," +
                FeedEntry.COLUMN_NAME + " TEXT," +
                FeedEntry.COLUMN_DESCRIPTION + " TEXT," +
                FeedEntry.COLUMN_RESOURCE_ID + " TEXT)";
        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
        public class HeroesDbHelper extends SQLiteOpenHelper {
            public static final int DATABASE_VERSION = 1;
            public static final String DATABASE_NAME = "Heroes.db";

            public HeroesDbHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(SQL_CREATE_ENTRIES);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                //TODO: Better onUpgrade
                db.execSQL(SQL_DELETE_ENTRIES);
                onCreate(db);
            }
        }

    }

}
