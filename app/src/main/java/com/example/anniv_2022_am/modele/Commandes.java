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

    public static String h1243(String[] args) {
        String res = "Erreur dans la commande.\n" +
                "Commande permettant d'obtenir le second chiffre du code.\n" +
                "Utilisation : h1234 [code]\n" +
                "Ce code s'obtient en appliquant les règles suivantes dans l'ordre à la suite de nombre récurrente :\n" +
                "\t- Suppression de tous les chiffres apparaissant plus de deux fois, sauf le second\n" +
                "\t- Suppression de tous les deux\n" +
                "\t- Application du masque binaire suivant : 86954\n" +
                "Commande aussi disponible en version graphique :\n" +
                "\t- h1243 [chiffre] : permet d'obtenir un chemin...";
        if(args.length == 2) {
            if(args[1].equals("02014")){
                res = "-------------\n" +
                        " Ξ Υ ∆ Ψ ε λ \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " • • • • • • \n" + " • • • • • • \n" +
                        " 0 2 1 3 9 5 \n" +
                        "-------------\n";
            } else {
                Random rnd = new Random();
                int bound = 10;
                byte[] array = new byte[bound+rnd.nextInt(bound)];
                rnd.nextBytes(array);
                res = new String(array, StandardCharsets.UTF_8);
                for(int i = 0; i < 2+rnd.nextInt(10); i++) {
                    array = new byte[bound+rnd.nextInt(bound)];
                    rnd.nextBytes(array);
                    res += "\n" + new String(array, StandardCharsets.UTF_8);
                }
            }
        }
        return res;
    }

    public static String amandine(String[] args) {
        return "amandine";
    }

    public static String swap(String[] args) {
        return "Changement de terminal...";
    }
}
