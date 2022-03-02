package com.example.anniv_2022_am.guiFragments.game.utils.cartes;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GridCartes {

    private List<Carte> cartes;

    public GridCartes(Rect hitbox, int nbligne, int nbcol, List<Pair<Class, Integer>> cartes) {
        this.cartes = new ArrayList<Carte>();

        int width_carte = hitbox.width()/nbcol;
        int height_carte = hitbox.height()/nbligne;
        int left = hitbox.left;
        int top = hitbox.top;
        for(int ligne = 0; ligne < nbligne; ligne++) {
            for(int col = 0; col < nbcol; col++) {
                Rect rect = new Rect(left, top, left+width_carte, top+height_carte);
                Pair<Class, Integer> pair = cartes.get(ligne*nbcol+col);
                try {
                    this.cartes.add((Carte) pair.first.getConstructors()[0].newInstance(rect, pair.second));
                } catch (Exception e) {
                    this.cartes.add(new Carte(rect, "?", 0));
                    e.printStackTrace();
                }
                left += width_carte;
            }
            left = hitbox.left;
            top += height_carte;
        }
    }

    public void draw(Canvas canvas) {
        for(Carte carte : this.cartes) {
            carte.draw(canvas);
        }
    }
}
