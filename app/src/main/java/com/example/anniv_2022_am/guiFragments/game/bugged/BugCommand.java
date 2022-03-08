package com.example.anniv_2022_am.guiFragments.game.bugged;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class BugCommand extends GameView {

    public BugCommand(Context context) { super(context); }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new BugCommandEngine(height, width);
    }
}
