package com.example.anniv_2022_am.guiFragments.game.demon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

public class DemonCommandEngine extends GameEngine {

    private TextCard hard;
    private TextCard seed;

    public DemonCommandEngine(int height, int width) {
        super(height, width);
        this.hard = new TextCard(new Rect(0,0,width/3, height/30), "Hard");
        this.hard.changeColorRect(Color.TRANSPARENT);
        this.hard.changeColorText(Color.MAGENTA);

        this.seed = new TextCard(new Rect(width/2, 29*height/30, 9*width/10, height), "Seed");
        this.seed.changeColorRect(Color.TRANSPARENT);
        this.seed.changeColorText(Color.MAGENTA);
    }

    @Override
    public void update() {

    }

    public void draw(Canvas canvas) {
        this.hard.draw(canvas);
        this.seed.draw(canvas);
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }
}
