package com.example.anniv_2022_am.guiFragments.game.utils.questions;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.game.utils.common.TextCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Question {

    private static final int background_question = Color.TRANSPARENT;
    private static final int foreground_question = Color.GRAY;

    private static final int backgroud_response = Color.DKGRAY;
    private static final int foreground_response = Color.WHITE;

    private TextCard question;
    private Map<TextCard, Boolean> responses;

    private static final Random rnd = new Random();

    public Question(Rect hitbox, String question, String[] vrai, String[] faux) {
        this.question = new TextCard(new Rect(hitbox.left, hitbox.top, hitbox.right, hitbox.height()/5), question);
        this.question.setTextSize(0.5f);

        this.responses = new HashMap<TextCard, Boolean>();

        int nbRect = vrai.length + faux.length;
        List<Rect> rects = new ArrayList<>();

        int bottom = hitbox.bottom;
        int heightresponses = hitbox.height()/8;
        int padding = hitbox.height()/20;

        for(int i = 0; i < nbRect; i++) {
            rects.add(new Rect(hitbox.left, bottom-heightresponses, hitbox.right, bottom));
            bottom -= (heightresponses+padding);
        }

        this.randomiseCard(rects, vrai, true);
        this.randomiseCard(rects, faux, false);
    }

    private void randomiseCard(List<Rect> rects, String[] values, Boolean areReponses) {
        for(String value : values) {
            Rect randomRect = rects.get(rnd.nextInt(rects.size()));
            rects.remove(randomRect);
            this.responses.put(new TextCard(randomRect, value), areReponses);
        }
    }

    public void draw(Canvas canvas) {
        this.question.draw(canvas);
        for(TextCard textCard : this.responses.keySet()) {
            textCard.draw(canvas);
        }
    }

    public boolean validate(int x, int y) throws OutOfAnswersException {
        for(TextCard textCard : this.responses.keySet()) {
            if(textCard.getCard().contains(x,y)) {
                return this.responses.get(textCard);
            }
        }
        throw new OutOfAnswersException();
    }
}
