package com.example.anniv_2022_am.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.modele.Fichier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    // Informations
    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "db_annivam_2022";
    private static final String DATABASE_TABLE_NAME = "fichiers";

    // Colon names
    private static final String PKEY_file = "nom";
    private static final String COL_date = "date";
    private static final String COL_desc = "description";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(Variables.TAG_Database, "Création de la base de données");
        String DATABASE_FAVORITE_CREATE = "CREATE TABLE " + DATABASE_TABLE_NAME + "(" +
                PKEY_file + " TEXT PRIMARY KEY," +
                COL_date + " TEXT," +
                COL_desc + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(DATABASE_FAVORITE_CREATE);

        this.addDefaultData(sqLiteDatabase);
    }

    private void addDefaultData(SQLiteDatabase sqLiteDatabase) {
        Log.i(Variables.TAG_Database,"Insert default data");
        sqLiteDatabase.beginTransaction();

        // Request
        String req = "INSERT INTO " + DATABASE_TABLE_NAME + " VALUES " +
                "('Application.pdf', '2022-02-15 11:00', 'Une petite description')," +
                "('test.mp3', '2022-02-15 11:45', 'Une autre petite description');";

        sqLiteDatabase.execSQL(req);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(Variables.TAG_Database, "Mise à jour de la base de données");
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);

        // create new table
        this.onCreate(sqLiteDatabase);
    }

    public List<Fichier> getFichiers() {
        List<Fichier> fichiers = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        // Create the request
        String select = "SELECT * FROM " + DATABASE_TABLE_NAME;

        // Process the values
        Cursor cursor = db.rawQuery(select, null);
        Log.i(Variables.TAG_Database, "Number of entries : " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                try {
                    fichiers.add(
                            new Fichier(
                                cursor.getString(cursor.getColumnIndex(PKEY_file)),
                                cursor.getString(cursor.getColumnIndex(COL_date)),
                                cursor.getString(cursor.getColumnIndex(COL_desc))
                            )
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

        return fichiers;
    }
}
