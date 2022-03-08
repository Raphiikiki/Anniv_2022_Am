package com.example.anniv_2022_am.guiFragments.game.demon;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class DemonCommand extends GameView {

    public DemonCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new DemonCommandEngine(super.getContext(), height, width);
    }
}
