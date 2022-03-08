package com.example.anniv_2022_am.guiFragments.game.demon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.PictureCard;
import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

import java.util.Random;

public class DemonCommandEngine extends GameEngine {

    private final TextCard hard;
    private final TextCard seed;
    private final PictureCard[] cards;

    private static final Random rnd = new Random();

    private final int color_background = Color.rgb(77,0,0);
    private final int color_text = Color.rgb(128,0,0);

    public DemonCommandEngine(Context context, int height, int width) {
        super(height, width);
        this.hard = new TextCard(new Rect(0,0,width/3, height/15), "Hard");
        this.hard.changeColorRect(this.color_background);
        this.hard.changeColorText(this.color_text);

        this.seed = new TextCard(new Rect(width/2, 14*height/15, 9*width/10, height), "Seed");
        this.seed.changeColorRect(this.color_background);
        this.seed.changeColorText(this.color_text);

        this.cards = new PictureCard[]{
                new PictureCard(context, new Rect(2*width/3, 0, width, width/3), "isaac/brimstone.png"),
                new PictureCard(context, new Rect(0,19*height/20, height/20, height), "isaac/isaac.png"),
                new PictureCard(context, new Rect(width/7, 3*height/11, 3*width/7, 3*height/11 + 2*width/7), "isaac/chaos.png"),
                new PictureCard(context, new Rect(width/2, 13*height/18, 3*width/4, 13*height/18+width/4), "isaac/darkbum.png"),
                new PictureCard(context, new Rect(width/10, 7*height/11, width/10+2*height/11, 9*height/11), "isaac/rkey.png"),
                new PictureCard(context, new Rect(3*width/4, 8*height/10, 19*width/20, 8*height/10+(19*width/20 - 3*width/4)), "isaac/sacredheart.png"),
                new PictureCard(context, new Rect(width/10, width/10, 3*width/10, 3*width/10), "isaac/jesusjuice.png"),
                new PictureCard(context, new Rect(width/3, height/50, 2*width/3, height/50+width/3), "isaac/momsbra.png"),
                new PictureCard(context, new Rect(width/2, height/3, 19*width/20, height/3 + (19*width/20-width/2)), "isaac/cancer.png")
        };
        for(PictureCard card : this.cards) {
            updateMouvCard(card);
        }
    }

    @Override
    public void update() {
        Rect plate = new Rect(0,0,getWidth(),getHeight());
        Random rnd = new Random();
        for(PictureCard card : this.cards) {
            card.update();
            if(!plate.contains(card.getHitbox())) {
                updateMouvCard(card);
            }
        }
    }

    public void updateMouvCard(PictureCard card) {
        int[] mouvs = new int[]{-1,1};
        card.setMovs(
                (1+rnd.nextInt((int)(0.01*getWidth())))*mouvs[rnd.nextInt(mouvs.length)],
                (1+rnd.nextInt((int)(0.01*getHeight())))*mouvs[rnd.nextInt(mouvs.length)]
        );
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(this.color_background);
        this.hard.draw(canvas);
        this.seed.draw(canvas);

        for(PictureCard card : this.cards) {
            card.draw(canvas);
        }
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) { }
}
