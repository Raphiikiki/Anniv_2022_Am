package com.example.anniv_2022_am.guiFragments.game.engines;

import com.example.anniv_2022_am.guiFragments.GameEngine;

public class TextEngine extends GameEngine {
    public TextEngine(int height, int width) {
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
