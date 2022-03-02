package com.example.anniv_2022_am.guiFragments.game.carte;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.example.anniv_2022_am.guiFragments.GameView;

public class CarteCommand extends GameView {

    private CarteCommandEngine engine;

    public CarteCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        this.engine = new CarteCommandEngine(height, width);
        super.gameEngine = this.engine;
    }

    @Override
    public void draw() {
        Canvas canvas = super.startDraw();
        if(canvas == null) return;

        // Draw stuff
        this.engine.getGridCartes().draw(canvas);

        super.endDraw(canvas);
    }
}
