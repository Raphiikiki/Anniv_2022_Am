package com.example.anniv_2022_am.guiFragments.game.bugged;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.gridscell.RandomGrid;

public class BugCommandEngine extends GameEngine {

    private RandomGrid randomGrid;

    public BugCommandEngine(int height, int width) {
        super(height, width);
        this.randomGrid = new RandomGrid(new Rect(0,0,width,height), 15, 8);
    }

    @Override
    public void draw(Canvas canvas) {
        this.randomGrid.draw(canvas);
    }

    @Override
    public void update() {
        this.randomGrid.update();
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }

}
