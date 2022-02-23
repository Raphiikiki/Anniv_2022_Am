package com.example.anniv_2022_am.guiFragments.game.welcome;

import android.content.Context;
import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.GameView;

public class WelcomeCommand extends GameView {

    private WelcomeCommandEngine engine;

    public WelcomeCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        this.engine = new WelcomeCommandEngine(height, width);
        super.gameEngine = this.engine;
    }

    @Override
    public void draw() {
        Canvas canvas = super.startDraw();
        if (canvas == null) return;

        this.engine.getTextCard().draw(canvas);

        super.endDraw(canvas);
    }
}
