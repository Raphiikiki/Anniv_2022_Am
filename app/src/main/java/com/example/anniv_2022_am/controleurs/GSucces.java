package com.example.anniv_2022_am.controleurs;

import android.content.Context;
import android.util.Log;

import com.example.anniv_2022_am.bdd.Database;
import com.example.anniv_2022_am.modele.Succes;

import java.util.List;

public class GSucces {

    // Attributes
    private static List<Succes> succes;
    private static Database db;

    public static void loadGSucces(Context context) {
        db = new Database(context);
        succes = db.getSucces();
    }

    public static void succesDone(String succes_done) {
        for(Succes succes : succes) {
            if(succes.getNom().toLowerCase().equals(succes_done.toLowerCase())) {
                succes.setDone();
                updateSucces();
                break;
            }
        }
    }

    public static List<Succes> getSucces() {
        return succes;
    }

    public static void updateSucces() {
        db.updateSucces(succes);
    }
}
