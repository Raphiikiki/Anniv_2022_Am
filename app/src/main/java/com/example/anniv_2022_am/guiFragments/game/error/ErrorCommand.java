package com.example.anniv_2022_am.guiFragments.game.error;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class ErrorCommand extends GameView {

    private ErrorCommandEngine engine;

    public ErrorCommand(Context context) { super(context); }

    @Override
    public void init(int height, int width) {
        this.engine = new ErrorCommandEngine(height, width);
        this.gameEngine = this.engine;
    }

    @Override
    public void draw() {
        Canvas canvas = startDraw();
        if(canvas == null) return;

        // Draw the stuff


        endDraw(canvas);
    }
}
