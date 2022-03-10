package com.example.anniv_2022_am.guiFragments.game.displaysix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.common.PictureCard;

import java.util.Random;

public class DisplaySixCommandEngine extends GameEngine {

    private PictureCard pictureCard;

    public DisplaySixCommandEngine(Context context, int height, int width) {
        super(height, width);
        this.pictureCard = new PictureCard(context, new Rect(height/2, width/2, height/2 + width/4, 3*width/4), "isaac/6.png");
        updateMouvCard(this.pictureCard);
    }

    @Override
    public void draw(Canvas canvas) {
        this.pictureCard.draw(canvas);
    }

    @Override
    public void update() {
        Rect plate = new Rect(0,0,getWidth(),getHeight());
        this.pictureCard.update();
        if(!plate.contains(this.pictureCard.getHitbox())) {
            updateMouvCard(this.pictureCard);
        }
    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) {

    }

    public void updateMouvCard(PictureCard card) {
        Random rnd = new Random();
        int[] mouvs = new int[]{-1,1};
        card.setMovs(
                (1+rnd.nextInt((int)(0.01*getWidth())))*mouvs[rnd.nextInt(mouvs.length)],
                (1+rnd.nextInt((int)(0.01*getHeight())))*mouvs[rnd.nextInt(mouvs.length)]
        );
    }
}
