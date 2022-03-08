package com.example.anniv_2022_am.guiFragments.game.displayfour;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.gridscell.Fourgrid;

public class DisplayFourCommandEngine extends GameEngine {

    private Fourgrid fourgrid;

    public DisplayFourCommandEngine(int height, int width) {
        super(height, width);
        this.fourgrid = new Fourgrid(new Rect(0,0,width,height));
    }

    @Override
    public void draw(Canvas canvas) {
        this.fourgrid.draw(canvas);
    }

    @Override
    public void update() {
        this.fourgrid.update();
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }
}
