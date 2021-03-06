package com.example.anniv_2022_am.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.modele.Fichier;
import com.example.anniv_2022_am.modele.Succes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    // Informations
    private static final int DATABASE_VERSION = 14;
    private static final String DATABASE_NAME = "db_annivam_2022";
    private static final String DATABASE_TABLE_NAME = "fichiers";
    private static final String DATABASE_SUCCES_NAME = "succes";

    // Colon names fichiers
    private static final String PKEY_file = "nom";
    private static final String COL_date = "date";
    private static final String COL_desc = "description";

    // Col names succes
    private static final String PKEY_suc = "nom";
    private static final String COL_done = "done";
    private static final String COL_text = "cond";

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

        String DATABASE_SUCCES_CREATE = "CREATE TABLE " + DATABASE_SUCCES_NAME + "(" +
                PKEY_suc + " TEXT PRIMARY KEY," +
                COL_done + " BOOLEAN," +
                COL_text + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(DATABASE_SUCCES_CREATE);

        this.addDefaultData(sqLiteDatabase);
    }

    private void addDefaultData(SQLiteDatabase sqLiteDatabase) {
        Log.i(Variables.TAG_Database,"Insert default data");
        sqLiteDatabase.beginTransaction();

        // Request
        String req = "INSERT INTO " + DATABASE_TABLE_NAME + " VALUES " +
                "('Application.pdf', '2022-03-20 00:00', 'Descriptif de cette application.')," +
                "('Colis.pdf', '2022-03-20 00:00', 'Découverte sur un paquet suspect.')," +
                "('Transport.pdf', '2022-03-20 00:00', 'Déplcement du colis.')," +
                "('initialisation.mp3', '2022-03-20 00:01', 'Un nouveau message vocal à été intercepté.')," +
                "('srdcdcper_1.mp3', '2022-03-20 11:34', 'Un nouveau message vocal à été intercepté.')," +
                "('srdcdcper_2.mp3', '2022-03-20 12:43', 'Un nouveau message vocal à été intercepté.')," +
                "('srdcdcper_3.mp3', '2022-03-20 14:03', 'Un nouveau message vocal à été intercepté.')," +
                "('fichier_inconnu.pdf', '2022-03-20 15:00', 'Un fichier inconnu à été intercepté.')," +
                "('srdcdcper_4.mp3', '2022-03-20 15:51', 'Un nouveau message vocal à été intercepté.');";
        sqLiteDatabase.execSQL(req);

        req = "INSERT INTO " + DATABASE_SUCCES_NAME + " VALUES " +
                "('Aidez moi.', 'FALSE', 'Utilisez la commande adéquate.')," +
                "('CHANGE', 'FALSE', 'Passez en version graphique.')," +
                "('Mes documents', 'FALSE', 'Explorez vos documents.')," +
                "('Les premiers pas', 'FALSE', 'Commencez la première énigme.')," +
                "('AsSomez-moi', 'FALSE', 'Obtenez le premier bout du code.')," +
                "('Mais quelle heure est-il?', 'FALSE', 'Commencez la seconde énigme.')," +
                "('Mon petit bout de chemin', 'FALSE', 'Accedez aux chemins.')," +
                "('DES LETTRES, QUE SIGNIFIENT-ELLES', 'FALSE', 'Déchiffrez le second chiffre du code.')," +
                "('Le démon', 'FALSE', 'A vous de jouer.')," +
                "('The devil', 'FALSE', 'Comprenez cet objet pour le chiffre numéro 3.')," +
                "('La fin.', 'FALSE', 'Obtenez le dernier chiffre.')," +
                "('...', 'FALSE', '...')," +
                "('Un nom ?', 'FALSE', 'Pourquoi moi ?');";
        sqLiteDatabase.execSQL(req);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(Variables.TAG_Database, "Mise à jour de la base de données");
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_SUCCES_NAME);

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

    public List<Succes> getSucces() {
        List<Succes> res = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        // Create the request
        String select = "SELECT * FROM " + DATABASE_SUCCES_NAME;

        // Process the values
        Cursor cursor = db.rawQuery(select, null);
        Log.i(Variables.TAG_Database, "Number of entries : " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                res.add(
                        new Succes(
                                cursor.getString(cursor.getColumnIndex(PKEY_suc)),
                                cursor.getInt(cursor.getColumnIndex(COL_done)) > 0,
                                cursor.getString(cursor.getColumnIndex(COL_text))
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();

        return res;
    }

    public void updateSucces(List<Succes> succesList) {
        Log.i(Variables.TAG_Database,"Update succes in the database");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();

        // Put the data to create a request
        ContentValues values;
        for(Succes succes : succesList) {
            values = new ContentValues();
            values.put(COL_done, succes.isDone());

            // Put it into the database
            db.update(DATABASE_SUCCES_NAME, values, PKEY_suc + " =?", new String[]{succes.getNom()});
            //db.insertOrThrow(DATABASE_TABLE_NAME,null, values);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
