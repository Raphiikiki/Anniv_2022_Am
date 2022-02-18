package com.example.anniv_2022_am.guiFragments.game.error;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class ErrorCommand extends GameView {

    public ErrorCommand(Context context) { super(context); }

    @Override
    public void init(int height, int width) {
        gameEngine = new ErrorCommandEngine(height, width);
    }

    @Override
    public void draw() {
        Canvas canvas = startDraw();
        if(canvas == null) return;

        // Draw the stuff


        endDraw(canvas);
    }
}
