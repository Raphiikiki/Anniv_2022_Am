package com.example.anniv_2022_am.guiFragments.game.utils.cartes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

public class Carte {

    private Rect hitbox;
    private TextCard shape;
    private TextCard value;

    private Paint paint_hitbox = new Paint();

    public Carte(Rect hitbox, String shape, int value, int color) {
        this.hitbox = hitbox;
        this.paint_hitbox.setColor(Color.TRANSPARENT);
        this.paint_hitbox.setStyle(Paint.Style.STROKE);
        this.paint_hitbox.setStrokeWidth(5);

        // Setup shape textcard
        int width_shape = this.hitbox.width()/4;
        Rect rect_shape = new Rect(this.hitbox.left + width_shape, this.hitbox.centerY()-width_shape, this.hitbox.right-width_shape, this.hitbox.centerY()+width_shape);
        this.shape = new TextCard(rect_shape, shape);
        this.shape.changeColorRect(Color.TRANSPARENT);
        this.shape.changeColorText(color);

        // Setup value textcard
        int width_value = this.hitbox.width()/8;
        Rect rect_value = new Rect(this.hitbox.right-width_value, this.hitbox.top, this.hitbox.right, this.hitbox.top+width_value);
        this.value = new TextCard(rect_value, String.valueOf(value));
        this.value.changeColorRect(Color.TRANSPARENT);
        this.value.changeColorText(color);
    }

    public Carte(Rect hitbox, String shape, int value) { this(hitbox, shape, value, Color.BLACK); }

    public void draw(Canvas canvas) {
        canvas.drawRect(this.hitbox, this.paint_hitbox);
        this.shape.draw(canvas);
        this.value.draw(canvas);
    }
}
