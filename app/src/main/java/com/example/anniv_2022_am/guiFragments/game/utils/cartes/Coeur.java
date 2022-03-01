package com.example.anniv_2022_am.guiFragments.game.utils.cartes;

import android.graphics.Color;
import android.graphics.Rect;

public class Coeur extends Carte {
    public Coeur(Rect hitbox, int value) {
        super(hitbox, "♥", value, Color.RED);
    }
}
