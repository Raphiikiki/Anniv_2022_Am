package com.example.anniv_2022_am.controleurs;

import androidx.fragment.app.Fragment;

import com.example.anniv_2022_am.modele.CommandesGUI;

import java.lang.reflect.Method;

public class GCommandesGUI {

    public static Fragment applyCommand(String command) {
        String[] action = parseCommand(command);
        Fragment res = new Fragment(); // A modifier
        try {
            Method multiplyStaticMethod = CommandesGUI.class.getDeclaredMethod( action[0], String[].class);
            res = (Fragment) multiplyStaticMethod.invoke(null, new Object[]{action});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private static String[] parseCommand(String command) {
        return command.toLowerCase().trim().split(" ");
    }
}
