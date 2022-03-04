package com.example.anniv_2022_am.guiFragments.game.utils.common;

import android.graphics.Color;
import android.graphics.Rect;

import java.util.Random;

public class RandomCell extends Cell {

    private Random rnd;

    public RandomCell(Rect hitbox) {
        super(hitbox);
        this.rnd = new Random();
    }

    public void update() {
        super.setColor(Color.argb(255, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
    }
}
