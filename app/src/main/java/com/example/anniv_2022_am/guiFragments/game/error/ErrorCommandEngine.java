package com.example.anniv_2022_am.guiFragments.game.error;

import com.example.anniv_2022_am.guiFragments.GameEngine;

public class ErrorCommandEngine extends GameEngine {

    public ErrorCommandEngine(int height, int width) {
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
