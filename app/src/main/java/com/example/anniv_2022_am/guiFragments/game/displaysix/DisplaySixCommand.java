package com.example.anniv_2022_am.guiFragments.game.displaysix;

import android.content.Context;

import com.example.anniv_2022_am.guiFragments.GameView;

public class DisplaySixCommand extends GameView {
    public DisplaySixCommand(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new DisplaySixCommandEngine(super.getContext(), height, width);
    }
}
