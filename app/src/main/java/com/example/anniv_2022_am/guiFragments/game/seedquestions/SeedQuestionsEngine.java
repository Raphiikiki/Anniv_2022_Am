package com.example.anniv_2022_am.guiFragments.game.seedquestions;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Pair;

import com.example.anniv_2022_am.guiFragments.GameEngine;
import com.example.anniv_2022_am.guiFragments.game.utils.questions.QuestionsManager;

import java.util.List;
import java.util.Map;

public class SeedQuestionsEngine extends GameEngine {

    private QuestionsManager questionsManager;

    public SeedQuestionsEngine(int height, int width, List<Pair<String, Pair<String[], String[]>>> questions) {
        super(height, width);
        this.questionsManager = new QuestionsManager(new Rect(0,0,width,height), questions);
    }

    @Override
    public void draw(Canvas canvas) {
        this.questionsManager.draw(canvas);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean haveToReset() {
        return false;
    }

    @Override
    public void touch(int x, int y) {
        this.questionsManager.select(x,y);
    }
}
