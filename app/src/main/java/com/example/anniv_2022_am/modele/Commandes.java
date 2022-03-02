package com.example.anniv_2022_am.modele;

import android.util.Log;
import android.util.Pair;

import com.example.anniv_2022_am.controleurs.Variables;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Commandes {

    public static String help(String[] args) {
        return "Bienvenue dans le centre d'aide.\n" +
                "\n" +
                "Les commandes disponibles dans la version textuelle :\n" +
                "\t- help : permet d'acceder au centre d'aide\n" +
                "\t- swap : permet d'acceder au terminal graphique\n" +
                "\n" +
                "Les commandes disponibles dans la version graphique :\n" +
                "\t- swap : permet d'acceder au terminal textuel";
    }

    public static String carte(String[] args) {
        String res = "Erreur dans la commande.\n" +
                "Commande permettant d'obtenir le premier chiffre du code.\n" +
                "Utilisation : carte [pique|coeur|carreau|trefle] [nombre]\n\n" +
                "Commande aussi disponible en version graphique :\n" +
                "\t- carte : permet d'afficher le plateau de carte\n" +
                "\t- carte [horizontal] [vertical] : permet d'obtenir le chiffre";
        Map<Pair<String, Integer>, String> types = new HashMap<Pair<String, Integer>, String>() {{
            put(new Pair<>("trefle", 39), "h x3");
            put(new Pair<>("pique", 29), "h 8x");
            put(new Pair<>("carreau", 32), "v 4x");
            put(new Pair<>("coeur", 23), "v x1");
        }};
        if (args.length == 3) {
            Log.d(Variables.TAG_Terminal, "Carte args : " + args[0] + " " + args[1]);
            try {
                int value = Integer.parseInt(args[2]);
                for(Pair<String, Integer> type : types.keySet()) {
                    if(type.first.equals(args[1])) {
                        if (type.second == value) {
                            res = types.get(type);
                        } else {
                            Random rnd = new Random();
                            byte[] array = new byte[4+rnd.nextInt(6)];
                            rnd.nextBytes(array);
                            res = new String(array, StandardCharsets.UTF_8);
                        }
                        break;
                    }
                }
            } catch(Exception e) {
                // Nothing happens
            }
        }
        return res;
    }

    public static String test(String[] args) {
        return "test commande";
    }

    public static String amandine(String[] args) {
        return "amandine";
    }

    public static String swap(String[] args) {
        return "Changement de terminal...";
    }
}
