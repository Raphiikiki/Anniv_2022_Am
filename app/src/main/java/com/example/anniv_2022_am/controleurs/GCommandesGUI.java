package com.example.anniv_2022_am.controleurs;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.anniv_2022_am.guiFragments.Game;
import com.example.anniv_2022_am.guiFragments.GameView;
import com.example.anniv_2022_am.guiFragments.game.error.ErrorCommand;
import com.example.anniv_2022_am.guiFragments.game.welcome.WelcomeCommand;
import com.example.anniv_2022_am.modele.CommandesGUI;

import java.lang.reflect.Method;

public class GCommandesGUI {

    public static GameView applyCommand(String command, Context context) {
        String[] action = parseCommand(command);
        GameView res = new ErrorCommand(context);
        try {
            Method multiplyStaticMethod = CommandesGUI.class.getDeclaredMethod(action[0], Context.class, String[].class);
            res = (GameView) multiplyStaticMethod.invoke(null, context, action);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private static String[] parseCommand(String command) {
        return command.toLowerCase().trim().split(" ");
    }

    public static boolean isSwap(GameView gm) {
        return gm == CommandesGUI.swap(null, null);
    }
}
