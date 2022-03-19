package com.example.anniv_2022_am.modele;

import android.content.Context;

import com.example.anniv_2022_am.controleurs.GSucces;
import com.example.anniv_2022_am.guiFragments.GameView;
import com.example.anniv_2022_am.guiFragments.game.bugged.BugCommand;
import com.example.anniv_2022_am.guiFragments.game.carte.CarteCommand;
import com.example.anniv_2022_am.guiFragments.game.chemins.CheminCommand;
import com.example.anniv_2022_am.guiFragments.game.demon.DemonCommand;
import com.example.anniv_2022_am.guiFragments.game.displayfour.DisplayFourCommand;
import com.example.anniv_2022_am.guiFragments.game.displaysix.DisplaySixCommand;
import com.example.anniv_2022_am.guiFragments.game.error.ErrorCommand;
import com.example.anniv_2022_am.guiFragments.game.kdo.Kdo;
import com.example.anniv_2022_am.guiFragments.game.seedquestions.SeedQuestions;

public class CommandesGUI {

    public static GameView swap(Context context, String[] args) {
        return null;
    }

    public static GameView carte(Context context, String[] args) {
        GameView res = new ErrorCommand(context);
        if (args.length == 1) { res = new CarteCommand(context); }
        else if(args.length == 3) {
            try {
                int horizontal = Integer.parseInt(args[1]);
                int vertical = Integer.parseInt(args[2]);
                if(horizontal == 83 && vertical == 41) {
                    GSucces.succesDone("AsSommez-moi");
                    res = new DisplayFourCommand(context);
                } else {
                    res = new BugCommand(context);
                }
            } catch (Exception e) {
                // Nothing
            }
        }
        return res;
    }

    public static GameView h1243(Context context, String[] args) {
        GameView res = new ErrorCommand(context);
        if(args.length == 2) {
            try {
                int value = Integer.parseInt(args[1]);
                res = new CheminCommand(context, value);
                GSucces.succesDone("DES LETTRES, QUE SIGNIFIENT-ELLES");
            } catch (Exception e) {
                // Nothing
            }
        }
        return res;
    }

    public static GameView demon(Context context, String[] args) {
        GameView res = new DemonCommand(context);
        if(args.length == 2 && args[1].equals("666mom")) {
            GSucces.succesDone("The devil");
            res = new DisplaySixCommand(context);
        }
        return res;
    }
    
    public static GameView seed(Context context, String[] args) {
        GameView res = new ErrorCommand(context);
        if(args.length == 2 && args[1].equals("hzscceld")) {
            GSucces.succesDone("Le démon");
            res = new SeedQuestions(context);
        }
        return res;
    }

    public static GameView code(Context context, String[] args) {
        GameView res = new ErrorCommand(context);
        if(args.length == 2 && args[1].equals("4269")) {
            GSucces.succesDone("...");
            res = new Kdo(context);
        }
        return res;
    }
}
