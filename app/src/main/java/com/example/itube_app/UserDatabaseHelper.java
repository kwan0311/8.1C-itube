package com.example.itube_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "DataBase_for_User";

    private static  final String TABLE_NAME = "userdata_table";
    private static  final String COLUMN_ID = "_id";
    private static final String COL1_fullname = "Fullname";
    private static final String COL2_Username = "Username";
    private static final String COL3_Password = "Password";




    public UserDatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1_fullname + " TEXT, " +
                COL2_Username + " TEXT, " +
                COL3_Password + " TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    void add_User(String Fullname, String Username, String Password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1_fullname, Fullname);
        contentValues.put(COL2_Username, Username);
        contentValues.put(COL3_Password, Password);


        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            Toast.makeText(context,"SORRY", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"OK!!!!!!!!!", Toast.LENGTH_SHORT).show();
        }
    }

    //check user name
    public Boolean checkUsername(String user_name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from TABLE_NAME where COL2_Username=?", new String[]{user_name});
        if(cursor.getCount() >0)
            return true;
        else
            return false;
    }

    //check username password
    public boolean checkUser(String username, String password) {
        SQLiteDatabase sdb= this.getReadableDatabase();
        String sql="select * from userdata_table where Username=? and Password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;


    }
}
