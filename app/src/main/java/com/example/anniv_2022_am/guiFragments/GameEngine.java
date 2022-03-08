package com.example.anniv_2022_am.guiFragments;

import android.graphics.Canvas;

public abstract class GameEngine {

    private int height;
    private int width;

    public GameEngine(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public abstract void draw(Canvas canvas);

    public abstract void update();

    public abstract boolean haveToReset();

    public abstract void touch(int x, int y);

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
