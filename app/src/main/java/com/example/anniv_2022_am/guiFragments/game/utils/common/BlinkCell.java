package com.example.anniv_2022_am.guiFragments.game.utils.common;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import java.util.Random;

public class BlinkCell extends Cell {

    private int count;
    private static final int display_count = 60;

    public BlinkCell(Rect hitbox) {
        super(hitbox);
        this.count = new Random().nextInt(display_count);
        this.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        if(count == display_count) {
            super.draw(canvas);
            count = 0;
        }
    }

    @Override
    public void update() {
        super.update();
        count++;
    }
}
