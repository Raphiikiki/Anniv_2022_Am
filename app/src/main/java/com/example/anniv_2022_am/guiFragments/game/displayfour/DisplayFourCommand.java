package com.example.anniv_2022_am.guiFragments.game.displayfour;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class DisplayFourCommand extends GameView {

    private DisplayFourCommandEngine engine;

    public DisplayFourCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        this.engine = new DisplayFourCommandEngine(height, width);
        super.gameEngine = this.engine;
    }

    @Override
    public void draw() {
        Canvas canvas = super.startDraw();
        if(canvas == null) return;

        this.engine.getGrid().draw(canvas);

        super.endDraw(canvas);
    }
}
