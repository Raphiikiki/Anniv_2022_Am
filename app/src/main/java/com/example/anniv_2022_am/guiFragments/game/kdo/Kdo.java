package com.example.anniv_2022_am.guiFragments.game.kdo;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class Kdo extends GameView {
    public Kdo(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new KdoEngine(height, width);
    }
}
