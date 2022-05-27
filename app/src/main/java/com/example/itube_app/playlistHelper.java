package com.example.itube_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class playlistHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "URL.db";
    private static final int DATABASE_VISION = 1;

    private static  final String TABLE_NAME = "personal_url";
    private static  final String COLUMN_ID = "_id";
    private static final String COL1_USERNAME = "Username";
    private static final String COL2_Urlcoce = "URLcode";



    public playlistHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VISION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1_USERNAME + " TEXT, " +
                COL2_Urlcoce + " TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    void add_Data1(String UserName, String Urlcoce)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1_USERNAME, UserName);
        contentValues.put(COL2_Urlcoce, Urlcoce);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            Toast.makeText(context,"SORRY", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"OK!!!!!!!!!", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor finddata(String username){
        Cursor cursor = getWritableDatabase().query(TABLE_NAME,null,COL1_USERNAME+"=?" ,new String[]{username},null,null,null);
        return cursor;
    }
}