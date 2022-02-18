package com.example.anniv_2022_am.guiFragments;

public abstract class GameEngine {

    private int height;
    private int width;

    public GameEngine(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public abstract void update();

    public abstract boolean haveToReset();

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
