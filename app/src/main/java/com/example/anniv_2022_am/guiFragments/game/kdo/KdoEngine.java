package com.example.anniv_2022_am.guiFragments.game.kdo;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

public class KdoEngine extends GameEngine {

    private TextCard textCard;

    public KdoEngine(int height, int width) {
        super(height, width);
        this.textCard = new TextCard(new Rect(0, 2*height/5, width, 3*height/5),"Envoie moi un screen de cette page...");
        this.textCard.setTextSize(0.5f);
    }

    @Override
    public void draw(Canvas canvas) {
        this.textCard.draw(canvas);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) {

    }
}
