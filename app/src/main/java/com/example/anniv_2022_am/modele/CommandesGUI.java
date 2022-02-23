package com.example.anniv_2022_am.modele;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;
import com.example.anniv_2022_am.guiFragments.game.carte.CarteCommand;

public class CommandesGUI {

    public static GameView swap(Context context, String[] args) {
        return null;
    }

    public static GameView carte(Context context, String[] args) { return new CarteCommand(context); }
}
