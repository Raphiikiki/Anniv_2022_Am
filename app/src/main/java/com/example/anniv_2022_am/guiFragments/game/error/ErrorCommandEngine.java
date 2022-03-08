package com.example.anniv_2022_am.guiFragments.game.error;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

public class ErrorCommandEngine extends GameEngine {

    private TextCard textCard;
    private int swap;
    private int current_time;
    private boolean display;

    public ErrorCommandEngine(int height, int width) {
        super(height, width);
        int height_rect = height/8;
        int width_rect = 3*width/4;
        int mid_rect_y = height/2;
        int mid_rect_x = width/2;
        Rect card = new Rect(mid_rect_x-width_rect/2, mid_rect_y-height_rect/2, mid_rect_x+width_rect/2, mid_rect_y+height_rect/2);
        String text = "Commande inconnue";
        this.textCard = new TextCard(card, text);
        this.textCard.changeColorRect(Color.RED);
        this.textCard.changeColorText(Color.WHITE);
        this.swap = 30;
        this.current_time = 0;
        this.display = true;
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.display)
            this.textCard.draw(canvas);
        else
            new TextCard(new Rect(), "").draw(canvas);
    }

    @Override
    public void update() {
        this.current_time++;
        if(this.swap == this.current_time) {
            this.current_time = 0;
            this.display = !this.display;
        }
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }
}
