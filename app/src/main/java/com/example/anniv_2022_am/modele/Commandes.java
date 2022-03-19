package com.example.anniv_2022_am.modele;

import android.util.Log;
import android.util.Pair;

import com.example.anniv_2022_am.controleurs.GSucces;
import com.example.anniv_2022_am.controleurs.Variables;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Commandes {

    public static String help(String[] args) {
        GSucces.succesDone("Aidez loi.");
        return "Bienvenue dans le centre d'aide.\n" +
                "\n" +
                "Les commandes disponibles dans la version textuelle :\n" +
                "\t- help : permet d'acceder au centre d'aide\n" +
                "\t- swap : permet d'acceder au terminal graphique\n" +
                "\t- code [code] : permet de tester une combinaison pour ouvrir le coffre\n" +
                "\n" +
                "Les commandes disponibles dans la version graphique :\n" +
                "\t- swap : permet d'acceder au terminal textuel";
    }

    public static String carte(String[] args) {
        GSucces.succesDone("Les premiers pas");
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
        GSucces.succesDone("Mais quelle heure est-il?");
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
                GSucces.succesDone("Mon petit bout de chemin");
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

    public static String demon(String[] args) {
        String res = "E̵̥̤̋͋r̸͕͖͌́r̶͔̣͆͐ẻ̵̩̂u̵̲̦͛̈r̶̨͇̊̽ ̶̓̄͜d̴͇̗̍̽ả̵̳͝ͅn̴̡̿ṣ̷̨̍ ̶̬̂̃l̴̻̉ä̴̙̏ ̵̨͛c̴̼̕ò̸̗̮m̵̙̾̌ͅm̸̛͚a̸̰͑n̴͙̩̾d̶̗̟́e̶̯̙̿͛.̶̣͎̍\n" +
                "̴͖͚̀̃C̵̺̃̃e̷̱̻̎t̷̘͚̾̾t̵̼̏̅ę̶͌ ̵̢̈́͝č̴̬͘o̷̢̓ͅm̶̹̩͐̽m̴̠̳̏̏a̵̝͋ͅn̷̪̟̈́̌d̸̳̕e̶̥̿̍ ̶͍̽̔n̷̬͝'̸̘̎é̵̳̮̚x̶̳͂̎i̴̺̬̿̈́s̵̪̓t̵̘̽e̷̜͗ ̵̖͊̊p̵̧̊͛a̵͙̟͒s̷̲̏͠ ̵̤̅e̵̠̍ñ̴̻̩ ̶̫̤̈́v̸̟̎ë̷̩̱̇r̷͉̦͋s̵̨͚̓̒ȋ̴̜̦ŏ̵̙̚n̵̮̙͗͘ ̸͙̽t̴̞̫̔ê̶͈̻̂x̸̳̼̐ț̵̝̈́̓ủ̵̦̳e̷̊͜͠ḽ̴̛̹l̷͈̞̋͆ḙ̶̄͜.̷̬̟̽\n" +
                "̵͈̽̕Ć̸͉͉ŏ̶͕m̴̤̬̏̈m̶͉͓̀ǎ̸̹ň̴͍̺͠d̴͚̈͒ę̸̣͒̕ ̵̩̈͊a̶̹̤̎́u̸̘͎̽s̷̮͚̀̄s̷͎̀̋i̶̼̥̕ ̵̲̠͒d̵̹͑i̶̖͐̀s̴̠̰̈p̴̠̀͠o̵͕͐ń̷͎̱̕ì̸͇͂b̷̫̀l̸̑͜͝ě̵̙̙ ̶̩͖͒e̵̝̊̃n̵̢͛̏ ̴̫̎̏v̵̹̣̀̆e̷̗͆̀r̵̫̀̓s̸͔͚͒̂i̵̥͛͠ͅo̵̱̣͐͂n̷͇̠̒͐ ̶͉̃̾g̵̡͑ȓ̴̠̃a̸͈͘p̸̺̄̂h̵͈̩̓̚ĭ̷͓q̵̻͓̏̀û̴̫͌e̴͖͛ ̴͍͖̓͠:̴͔̬̃\n" +
                "̵̯̣̈́̓-̸̦̽ ̵͎̩̾d̶̡̘͒e̵̦̿̽ṃ̸̔o̴͓̐ń̸̤̼ ̵̣̤̉:̵̟̖̓̃ ̵͍̄6̴̬̽͠6̸̯͉̏6̷̬͓̇\n" +
                "̴̦͓͝\n" +
                "̸̝͍͐̀C̶̣͌̋o̴̜̔͜m̴̙̏͝ḿ̷̛̱a̶̢̯͛͛n̸̞͝d̴͍͉̄͌e̷͈̒̚ ̴̧̉a̴̪̅̕s̴̩̭̉̓s̴̽͘ͅȍ̴̜͐c̸͕͑̓ì̶͎̪ę̶̙́͠e̷͎̗̓̄ ̵͈̽͒s̴̝̑̌ų̸̹́r̴̫̣͂̔ ̸̰͗͝l̷̠̚e̷̖̦̅͆ ̶͍̎͘ẗ̷̖͓́̊ḙ̶́̚r̶̩͛m̶͖̀̐i̴̠̩͂́n̴̯̾̉ä̸͓̙́͌l̷͖̃̏ ̷͚̈g̵̪̲͛̚r̴̬̪̈a̸͔̙͠p̶͕̈́ḧ̷́͜ỉ̷̪̱͘q̵͙͌̔ŭ̸̞̩e̸͓͒:̸͓̿͋\n" +
                "̷̬̉͘-̶̹̆ ̵͖͂s̴͚͎͗ȇ̶̮e̸̦͕̽͝d̶̖̆̇ ̶̪̾[̶̲̥̔͊s̴̼̈́̊e̸̫̱͗e̶͙̅͗d̵̩̉̅]̷̰̊̉ ̸̥͍̓̍";
        return res;
    }

    public static String code(String[] args) {
        GSucces.succesDone("...");
        String res = "Code incorrect.\n" +
                "Utilisation : code [code]";
        if(args.length == 2 && args[1].equals("4269")) {
            GSucces.succesDone("La fin.");
            res = "C'est bel et bien la fin\n" +
                    "J'espère que ce n'était pas trop dur et que tu as quand même pris du plaisir à le faire!\n" +
                    "Je sais que c'est sans doute déceptif et pas super bien réalisé.\n" +
                    "Je te donnerai ton cadeau quand on se verra, certainement pour ta soirée d'anniverssaire.\n" +
                    "Passe encore une merveilleuse fin de journée, j'espère qu'elle c'est bien passée d'ailleurs, et à ce soir pour la soirée Among Us.\n" +
                    "Je t'aime ❤";
        }
        return res;
    }

    public static String amandine(String[] args) {
        GSucces.succesDone("Un nom ?");
        return "❤";
    }

    public static String swap(String[] args) {
        GSucces.succesDone("CHANGE");
        return "Changement de terminal...";
    }
}
