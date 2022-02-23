package com.example.anniv_2022_am.guiFragments.game.carte;

import com.example.anniv_2022_am.guiFragments.GameEngine;

public class CarteCommandEngine extends GameEngine {

    public CarteCommandEngine(int height, int width) {
        super(height, width);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean haveToReset() {
        return false;
    }
}
