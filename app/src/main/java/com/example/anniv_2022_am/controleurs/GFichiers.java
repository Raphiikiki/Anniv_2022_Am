package com.example.anniv_2022_am.controleurs;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.anniv_2022_am.bdd.Database;
import com.example.anniv_2022_am.modele.Fichier;

import java.util.List;

public class GFichiers {

    // Attributes
    private static List<Fichier> fichiers;
    private static AssetManager assetManager;

    private GFichiers() { }

    public static void loadGFichiers(Context context) {
        Database db = new Database(context);
        fichiers = db.getFichiers();

        for (Fichier fichier : fichiers) {
            Log.d(Variables.TAG_Notifications, fichier.toString());
        }

        assetManager = context.getAssets();
    }

}
