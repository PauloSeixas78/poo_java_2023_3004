package com.example.pupfeeder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class Databasehelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS = "pupfeeder";
    private static int VERSION = 1;


    public Databasehelper(Context context){
        super(context,BANCO_DADOS,null,VERSION);
    }

    @Override
     public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE racoes(_id INTEGER PRIMARY KEY, marca TEXT, quantidade INTEGER,tipo TEXT, porte TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldversion,int newversion){

    }
}
