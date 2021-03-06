package com.example.anniv_2022_am.guiFragments.game.chemins;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.anniv_2022_am.guiFragments.GameView;
import com.example.anniv_2022_am.guiFragments.game.chemins.CheminCommandEngine.Mouv;

import java.util.HashMap;
import java.util.Map;

public class CheminCommand extends GameView {

    private int value;
    private Map<Integer, Mouv[]> paths = new HashMap<Integer, Mouv[]>() {{
        put(2, new Mouv[]{Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.RIGHT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.RIGHT, Mouv.BOTTOM, Mouv.RIGHT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.LEFT, Mouv.TOP});
        put(1, new Mouv[]{Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.RIGHT, Mouv.RIGHT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.BOTTOM, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.TOP, Mouv.TOP});
        put(0, new Mouv[]{Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.RIGHT, Mouv.RIGHT, Mouv.RIGHT, Mouv.RIGHT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.LEFT, Mouv.LEFT, Mouv.LEFT, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.TOP, Mouv.TOP});
        put(3, new Mouv[]{Mouv.TOP, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.TOP, Mouv.RIGHT, Mouv.RIGHT, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.TOP, Mouv.TOP, Mouv.LEFT, Mouv.LEFT, Mouv.TOP, Mouv.TOP});
    }};

    public CheminCommand(Context context) { super(context); }

    public CheminCommand(Context context, int value) {
        super(context);
        this.value = value;
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new CheminCommandEngine(height, width, this.paths.get(this.value));
    }
}
