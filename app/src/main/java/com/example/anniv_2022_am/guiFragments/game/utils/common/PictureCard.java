package com.example.anniv_2022_am.guiFragments.game.utils.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.anniv_2022_am.controleurs.Utils;
import com.example.anniv_2022_am.controleurs.Variables;

public class PictureCard {

    private Paint paint = new Paint();
    private Bitmap picture;
    private Rect picture_hibox;
    private Rect hitbox;

    private Rect last_hitbox;

    private double dx;
    private double dy;

    public PictureCard(Context context, Rect hitbox, String path) {
        this.hitbox = hitbox;
        this.last_hitbox = new Rect(hitbox);
        this.picture = Utils.getBitmapFromAssets(context, path, hitbox);
        this.picture_hibox = new Rect(0,0,hitbox.width(),hitbox.height());
        this.dx = 0;
        this.dy = 0;
    }

    public void setMovs(double dx, double dy) {
        this.hitbox = new Rect(this.last_hitbox);
        this.dx = dx;
        this.dy = dy;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.picture, this.picture_hibox, this.hitbox, this.paint);
    }

    public void offset(int x, int y) {
        this.last_hitbox = new Rect(this.hitbox);
        this.hitbox.offset(x, y);
    }

    public void update() {
        this.offset((int)this.dx, (int)this.dy);
    }

    public Rect getHitbox() {
        return hitbox;
    }
}
