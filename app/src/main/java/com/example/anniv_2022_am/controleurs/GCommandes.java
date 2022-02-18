package com.example.anniv_2022_am.controleurs;

import com.example.anniv_2022_am.modele.Commandes;

import java.lang.reflect.Method;

public class GCommandes {

    public static String applyCommand(String command) {
        String[] action = parseCommand(command);
        String res = "La commande n'éxiste pas";
        try {
            Method multiplyStaticMethod = Commandes.class.getDeclaredMethod( action[0], String[].class);
            res = (String) multiplyStaticMethod.invoke(null, new Object[]{action});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private static String[] parseCommand(String command) {
        return command.toLowerCase().trim().split(" ");
    }
}
