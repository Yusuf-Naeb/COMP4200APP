package com.example.my_his;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database_Func extends SQLiteOpenHelper{
    //Strings for table and column names, as well as name of database
    private static final String DATABASE_BD = "Database.db";
    private static final String Table_USER = "User";
    public static final String COLUMN_NAME_USERNAME = "Username";
    public static final String COLUMN_NAME_PASSWORD = "Password";
    public static final String COLUMN_NAME_NAME = "Name";
    public static final String COLUMN_NAME_UID = "User_ID";
    private static final String Table_MOOD = "Mood";
    public static final String COLUMN_NAME_Mood = "Mood";
    public static final String COLUMN_NAME_DATE = "Date";
    public static final String COLUMN_NAME_MOOD_2 = "Second_Mood";
    public static final String COLUMN_NAME_MOOD_ID = "Mood_ID";
    public static final int DATABASE_VERSION = 1;
    //sql code to create tables
    private static final String SQL_CREATE_User = "CREATE TABLE " +
            Table_USER + " (" + COLUMN_NAME_USERNAME + " TEXT NOT NULL, " +
            COLUMN_NAME_PASSWORD + " TEXT NOT NULL, " +
            COLUMN_NAME_NAME + " TEXT DEFAULT 'N/A' NOT NULL," +
            COLUMN_NAME_UID + " INTEGER PRIMARY KEY AUTOINCREMENT)";
    private static final String SQL_CREATE_Moods = "CREATE TABLE " +
            Table_MOOD + " (" + COLUMN_NAME_UID + " INTEGER NOT NULL," +
            COLUMN_NAME_Mood + " TEXT DEFAULT 'No Mood' NOT NULL," +
            COLUMN_NAME_MOOD_2 + " TEXT DEFAULT 'No Mood' NOT NULL," +
            COLUMN_NAME_DATE + " DATETIME NOT NULL, "
            + COLUMN_NAME_MOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT)";
    //constructor for dbhandler
    public Database_Func(Context context) {
        super(context, DATABASE_BD, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //this creates the database
        db.execSQL(SQL_CREATE_User);
        db.execSQL(SQL_CREATE_Moods);
    }

    public void addUser(String Uname, String pass, String nme){
        SQLiteDatabase db = this.getWritableDatabase();
        //create contentvalues object
        ContentValues values = new ContentValues();
        //insert values into contentvalues
        values.put(COLUMN_NAME_USERNAME, Uname);
        values.put(COLUMN_NAME_PASSWORD, nme);
        if ( nme != null){
            values.put(COLUMN_NAME_NAME, nme);
        }
        //insert the data into database
        db.insert(Table_USER, null, values);

        db.close();
    }

    public void editUser(String Uname, String pass, int id, String nme){
        SQLiteDatabase db = this.getWritableDatabase();
        //create contentvalues object
        ContentValues values = new ContentValues();
        //insert values into contentvalues
        values.put(COLUMN_NAME_USERNAME, Uname);
        values.put(COLUMN_NAME_PASSWORD, nme);
        if ( nme != null){
            values.put(COLUMN_NAME_NAME, nme);
        }
        //update the database
        db.update(Table_USER, values, COLUMN_NAME_UID +" = ?", new String[]{Integer.toString(id)});
        db.close();
    }

    public void addMood(String mood, String mood2, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        //get the time, and create contentvalues object
        Date currenttime = Calendar.getInstance().getTime();
        ContentValues values = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //insert values into contentvalues
        if(mood != null){
            values.put(COLUMN_NAME_Mood, mood);
        }
        values.put(COLUMN_NAME_DATE, dateFormat.format(currenttime));
        if(mood2 != null){
            values.put(COLUMN_NAME_MOOD_2, mood2);
        }
        values.put(COLUMN_NAME_UID, id);
        //insert data into database
        db.insert(Table_MOOD, null, values);
        db.close();
    }

    public void editMood(String mood, String mood2, int mid){
        SQLiteDatabase db = this.getWritableDatabase();
        //create contentvalues object
        ContentValues values = new ContentValues();
        //insert values into contentvalues
        if(mood != null){
            values.put(COLUMN_NAME_Mood, mood);
        }
        if(mood2 != null){
            values.put(COLUMN_NAME_MOOD_2, mood2);
        }
        //update the database
        db.update(Table_MOOD, values, COLUMN_NAME_MOOD_ID + " = ?", new String[]{Integer.toString(mid)});
        db.close();
    }

    public ArrayList<User> getUser(String username, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        //sql to get desired data
        String GET_USER = "SELECT * FROM "
                + Table_USER + " WHERE " + Table_USER + "."
                + COLUMN_NAME_PASSWORD + " == " + pass
                + " and " + Table_USER + "." + COLUMN_NAME_USERNAME + " == "
                + username;
        //create cursor to execute sql
        Cursor CurUser = db.rawQuery(GET_USER, null);
        //create arraylist and insert data
        ArrayList<User> UserIn = new ArrayList<>();
        UserIn.add(new User(CurUser.getString(0),
                CurUser.getString(1),
                Integer.parseInt(CurUser.getString(3)),
                CurUser.getString(2)));
        //CLOSE CURSOR AND RETURN DATA
        CurUser.close();
        return UserIn;
    }

    public ArrayList<Mood_His> getMoodHist(int ID){
        SQLiteDatabase db = this.getReadableDatabase();
        //sql to get desired data
        String GET_MOOD = "SELECT * FROM " + Table_MOOD + " WHERE " +
                Table_MOOD + "." + COLUMN_NAME_UID + " == " + ID;
        //create cursor to execute sql
        Cursor Moodcurs = db.rawQuery(GET_MOOD, null);
        //create arraylist and insert data
        ArrayList<Mood_His> Moods = new ArrayList<>();
        //loop to insert data
        if(Moodcurs.moveToFirst()){
            do{
                Moods.add(new Mood_His(Integer.parseInt(Moodcurs.getString(0)),
                        Integer.parseInt(Moodcurs.getString(4)),
                        Moodcurs.getString(1),
                        Moodcurs.getString(2),
                        Moodcurs.getString(3)));
            }while (Moodcurs.moveToNext());
        }
        //close cursor and return data
        Moodcurs.close();
        return Moods;
    }

    public ArrayList<Mood_His> getAllMoodHist(){
        SQLiteDatabase db = this.getReadableDatabase();
        //sql to get desired data
        String GET_MOOD = "SELECT * FROM " + Table_MOOD;
        //create cursor to execute sql
        Cursor Moodcurs = db.rawQuery(GET_MOOD, null);
        //create arraylist and insert data
        ArrayList<Mood_His> Moods = new ArrayList<>();
        //loop to insert data
        if(Moodcurs.moveToFirst()){
            do{
                Moods.add(new Mood_His(Integer.parseInt(Moodcurs.getString(0)),
                        Integer.parseInt(Moodcurs.getString(4)),
                        Moodcurs.getString(1),
                        Moodcurs.getString(2),
                        Moodcurs.getString(3)));
            }while (Moodcurs.moveToNext());
        }
        //close cursor and return data
        Moodcurs.close();
        return Moods;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this checks if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_USER);
        db.execSQL("DROP TABLE IF EXISTS " + Table_MOOD);
        onCreate(db);
    }
}
