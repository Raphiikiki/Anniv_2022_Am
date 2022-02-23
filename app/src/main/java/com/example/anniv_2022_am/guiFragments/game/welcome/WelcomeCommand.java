package com.example.anniv_2022_am.guiFragments.game.welcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.example.anniv_2022_am.guiFragments.GameView;

public class WelcomeCommand extends GameView {
    public WelcomeCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new WelcomeEngine(height, width);
    }

    @Override
    public void draw() {
        Canvas canvas = super.startDraw();
        if (canvas == null) return;

        this.setBackgroundColor(Color.YELLOW);

        super.endDraw(canvas);
    }
}
