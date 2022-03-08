package com.example.anniv_2022_am.guiFragments.game.welcome;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class WelcomeCommand extends GameView {

    public WelcomeCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new WelcomeCommandEngine(height, width);
    }
}
