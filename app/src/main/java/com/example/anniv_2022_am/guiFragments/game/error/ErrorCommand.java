package com.example.anniv_2022_am.guiFragments.game.error;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class ErrorCommand extends GameView {

    private ErrorCommandEngine engine;

    public ErrorCommand(Context context) { super(context); }

    @Override
    public void init(int height, int width) {
        this.gameEngine = new ErrorCommandEngine(height, width);
    }
}
