package com.example.anniv_2022_am.guiFragments.game.welcome;

import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

public class WelcomeCommandEngine extends GameEngine {

    private TextCard textCard;

    public WelcomeCommandEngine(int height, int width) {
        super(height, width);
        int height_rect = height/8;
        int width_rect = 3*width/4;
        int mid_rect_y = height/2;
        int mid_rect_x = width/2;
        Rect card = new Rect(mid_rect_x-width_rect/2, mid_rect_y-height_rect/2, mid_rect_x+width_rect/2, mid_rect_y+height_rect/2);
        String text = "En attente d'une commande...";
        this.textCard = new TextCard(card, text);
    }

    @Override
    public void update() {

    }

    public TextCard getTextCard() {
        return this.textCard;
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

}
