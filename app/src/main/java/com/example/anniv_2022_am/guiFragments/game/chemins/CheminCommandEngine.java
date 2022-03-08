package com.example.anniv_2022_am.guiFragments.game.chemins;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class CheminCommandEngine extends GameEngine {

    public enum Mouv {LEFT, TOP, RIGHT, BOTTOM}
    private Map<Mouv, String> displayMouv = new HashMap<Mouv, String>() {{
        put(Mouv.LEFT, "⇐"); put(Mouv.TOP, "⇑"); put(Mouv.RIGHT, "⇒"); put(Mouv.BOTTOM, "⇓");
    }};

    private Stack<Mouv> path;
    private int count;
    private final static int swap_count = 20;
    private TextCard textCard;
    private boolean reset = false;
    private TextCard resetbtn;

    public CheminCommandEngine(int height, int width, Mouv[] path) {
        super(height, width);
        if (path == null || path.length == 0) {
            Random rnd = new Random();
            path = new Mouv[15 + rnd.nextInt(10)];
            for(int i = 0; i < path.length; i++) {
                path[i] = Mouv.values()[rnd.nextInt(Mouv.values().length)];
            }
        }
        this.path = new Stack<>();
        Collections.addAll(this.path, path);
        this.count = 0;
        this.textCard = new TextCard(new Rect(0,0,width,height), "");
        this.textCard.changeColorRect(Color.TRANSPARENT);
        this.textCard.changeColorText(Color.BLUE);

        int center_y = height/2;
        this.resetbtn = new TextCard(new Rect(width/4, center_y-height/15, 3*width/4, center_y+height/15), "Revoir");
    }

    @Override
    public void draw(Canvas canvas) {
        if(this.path.isEmpty()) {
            this.resetbtn.draw(canvas);
        } else {
            this.textCard.draw(canvas);
        }
    }

    @Override
    public void update() {
        if(!this.path.isEmpty()) {
            if(this.count == swap_count) {
                this.count = -5;
                this.textCard.setText("");
            } else if(this.count == 0) {
                this.popPath();
            }
            this.count++;
        }
    }

    @Override
    public boolean haveToReset() {
        return this.reset;
    }

    @Override
    public void touch(int x, int y) {
        if(this.resetbtn.getCard().contains(x, y)) {
            this.reset = true;
        }
    }

    private void popPath() {
        if(!this.path.isEmpty()) {
            this.textCard.setText(this.displayMouv.get(this.path.pop()));
        }
    }
}
