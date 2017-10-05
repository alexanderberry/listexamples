package com.example.berry.listexamples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.berry.listexamples.HeroesContract.HeroEntry.TABLE_NAME;

/**
 * Created by per6 on 10/5/17.
 */
public class HeroesDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Heroes.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HeroesContract.HeroEntry.TABLE_NAME + " (" +
                    HeroesContract.HeroEntry._ID + " INTEGER PRIMARY KEY," +
                    HeroesContract.HeroEntry.COLUMN_NAME + " TEXT," +
                    HeroesContract.HeroEntry.COLUMN_DESCRIPTION + " TEXT," +
                    HeroesContract.HeroEntry.COLUMN_RESOURCE_ID + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

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

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
