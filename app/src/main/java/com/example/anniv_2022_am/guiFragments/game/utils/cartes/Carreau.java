package com.example.anniv_2022_am.guiFragments.game.utils.cartes;

import android.graphics.Color;
import android.graphics.Rect;

public class Carreau extends Carte {
    public Carreau(Rect hitbox, int value) {
        super(hitbox, "♦", value, Color.RED);
    }
}
