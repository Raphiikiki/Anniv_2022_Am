package com.example.anniv_2022_am.guiFragments.game.utils.gridscell;

import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.game.utils.common.Cell;
import com.example.anniv_2022_am.guiFragments.game.utils.common.RandomCell;

import java.util.ArrayList;
import java.util.List;

public class RandomGrid extends GridCell {

    private int count;
    private static final int count_swap = 10;

    public RandomGrid(Rect hitbox, int nbline, int nbcol) {
        super();
        List<Cell> cells = new ArrayList<>();
        int width = hitbox.width()/nbcol;
        int height = hitbox.height()/nbline;
        int left = hitbox.left;
        int top = hitbox.top;
        for(int line  = 0; line < nbline; line++) {
            for(int col = 0; col < nbcol; col++) {
                Rect cellbox = new Rect(left, top, left+width, top+height);
                cells.add(new RandomCell(cellbox));
                left+=width;
            }
            top += height;
            left = hitbox.left;
        }
        this.setCells(cells);
        this.count = 0;
    }

    @Override
    public void update() {
        count++;
        if(count == count_swap) {
            super.update();
            count = 0;
        }

    }
}
