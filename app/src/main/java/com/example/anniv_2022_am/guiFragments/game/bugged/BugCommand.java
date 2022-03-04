package com.example.anniv_2022_am.guiFragments.game.bugged;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class BugCommand extends GameView {

    private BugCommandEngine engine;

    public BugCommand(Context context) { super(context); }

    @Override
    public void init(int height, int width) {
        this.engine = new BugCommandEngine(height, width);
        super.gameEngine = this.engine;
    }

    @Override
    public void draw() {
        Canvas canvas = super.startDraw();
        if(canvas == null) return;

        this.engine.getRandomGrid().draw(canvas);

        super.endDraw(canvas);
    }
}
