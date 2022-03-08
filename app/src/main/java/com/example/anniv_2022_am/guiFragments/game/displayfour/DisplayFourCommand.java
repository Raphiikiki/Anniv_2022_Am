package com.example.anniv_2022_am.guiFragments.game.displayfour;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class DisplayFourCommand extends GameView {

    public DisplayFourCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new DisplayFourCommandEngine(height, width);
    }
}
