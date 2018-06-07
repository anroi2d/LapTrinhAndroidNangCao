package com.lecongan.app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lecongan.app.model.Person;

/**
 * Created by Admin on 17/03/2018.
 */

public class DBManager extends SQLiteOpenHelper {
    private Context context;
    private static final String DATA_NAME = "testSql";
    private static final String TABLE_NAME = "person";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TXT = "txt";
    private static final int DATA_VERSION = 1;
    private String sqlQuery = "create table "+TABLE_NAME +"( "+
            ID + " integer primary key, "+
            NAME +" TEXT, "+
            TXT +" TEXT )";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DBManager(Context context) {
        super(context, DATA_NAME, null, DATA_VERSION);
        this.context = context;
    }
    public void addPerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, person.getId());
        values.put(NAME, person.getName());
        values.put(TXT, person.getMessage());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
