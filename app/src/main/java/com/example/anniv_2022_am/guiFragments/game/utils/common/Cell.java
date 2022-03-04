package com.example.anniv_2022_am.guiFragments.game.utils.common;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Cell {

    private Rect hitbox;
    private Paint paint;

    public Cell(Rect hitbox) {
        this.hitbox = hitbox;
        this.paint = new Paint();
        this.paint.setColor(Color.TRANSPARENT);
    }

    public Cell(Rect hitbox, Paint paint) {
        this.hitbox = hitbox;
        this.paint = paint;
    }

    public void setColor(int color) {
        this.paint.setColor(color);
    }

    public Rect getHitbox() {
        return hitbox;
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(this.hitbox, this.paint);
    }

    public void update() {
        // Nothing
    }
}
