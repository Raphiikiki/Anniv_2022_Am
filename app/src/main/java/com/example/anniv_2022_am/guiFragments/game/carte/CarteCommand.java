package com.example.anniv_2022_am.guiFragments.game.carte;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class CarteCommand extends GameView {

    public CarteCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new CarteCommandEngine(height, width);
    }

}
