package com.example.anniv_2022_am.guiFragments.game.utils.questions;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionsManager {

    private List<Question> questions;
    private int current_question;

    public QuestionsManager(Rect hitbox, List<Pair<String, Pair<String[], String[]>>> questions) {
        this.questions = new ArrayList<>();
        for(Pair<String, Pair<String[], String[]>> values : questions) {
            Pair<String[], String[]> pair = values.second;
            this.questions.add(new Question(hitbox, values.first, pair.first, pair.second));
        }
        this.current_question = 0;
    }

    public void draw(Canvas canvas) {
        this.questions.get(this.current_question).draw(canvas);
    }

    public void select(int x, int y) {
        try {
            if(this.questions.get(this.current_question).validate(x,y)) {
                this.current_question++;
            } else {
                this.current_question = 0;
            }
        } catch (OutOfAnswersException e) {
            // Nothing
        }
    }
}
