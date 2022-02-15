package com.example.anniv_2022_am.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.anniv_2022_am.controlleurs.Variables;

public class Database extends SQLiteOpenHelper {

    // Informations
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_annivam_2022";
    private static final String DATABASE_TABLE_NAME = "fichiers";

    // Colon names
    private static final String PKEY_file = "nom";
    private static final String PKEY_date = "date";
    private static final String COL_type = "type";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(Variables.TAG_Database, "Création de la base de données");
        String DATABASE_FAVORITE_CREATE = "CREATE TABLE " + DATABASE_TABLE_NAME + "(" +
                PKEY_file + " TEXT PRIMARY KEY," +
                PKEY_date + " INTEGER PRIMARY KEY," +
                COL_type + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(DATABASE_FAVORITE_CREATE);

        this.addDefaultData();
    }

    private void addDefaultData() {
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(Variables.TAG_Database, "Mise à jour de la base de données");
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);

        // create new table
        this.onCreate(sqLiteDatabase);
    }
}
