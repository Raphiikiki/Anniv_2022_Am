package com.example.anniv_2022_am.guiFragments.game.carte;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.util.Pair;

import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.cartes.Carreau;
import com.example.anniv_2022_am.guiFragments.game.utils.cartes.Coeur;
import com.example.anniv_2022_am.guiFragments.game.utils.cartes.GridCartes;
import com.example.anniv_2022_am.guiFragments.game.utils.cartes.Pique;
import com.example.anniv_2022_am.guiFragments.game.utils.cartes.Trefle;

import java.util.ArrayList;
import java.util.List;

public class CarteCommandEngine extends GameEngine {

    private final GridCartes gridCartes;

    public CarteCommandEngine(int height, int width) {
        super(height, width);
        //Rect rect = new Rect(0, height/2 - width/2, width, height/2 + width/2);
        Rect rect = new Rect(0, (int)(0.1*height), width, (int)(0.9*height));
        List<Pair<Class, Integer>> cartes = new ArrayList<Pair<Class, Integer>>() {{
            add(new Pair<>(Trefle.class, 5));add(new Pair<>(Coeur.class, 8));add(new Pair<>(Carreau.class, 4));add(new Pair<>(Trefle.class, 1));add(new Pair<>(Pique.class, 3));
            add(new Pair<>(Carreau.class, 2));add(new Pair<>(Pique.class, 7));add(new Pair<>(Trefle.class, 9));add(new Pair<>(Pique.class, 6));add(new Pair<>(Coeur.class, 5));
            add(new Pair<>(Pique.class, 8));add(new Pair<>(Coeur.class, 2));add(new Pair<>(Carreau.class, 4));add(new Pair<>(Trefle.class, 9));add(new Pair<>(Carreau.class, 1));
            add(new Pair<>(Trefle.class, 3));add(new Pair<>(Carreau.class, 9));add(new Pair<>(Pique.class, 5));add(new Pair<>(Coeur.class, 3));add(new Pair<>(Carreau.class, 7));
            add(new Pair<>(Coeur.class, 4));add(new Pair<>(Trefle.class, 4));add(new Pair<>(Coeur.class, 1));add(new Pair<>(Carreau.class, 5));add(new Pair<>(Trefle.class, 8));
        }};
        Log.d(Variables.TAG_Terminal, "Nombre de valeur dans la liste : " + cartes.size());
        this.gridCartes = new GridCartes(rect, 5, 5, cartes);
    }

    @Override
    public void draw(Canvas canvas) {
        this.gridCartes.draw(canvas);
    }

    @Override
    public void update() { }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }
}
