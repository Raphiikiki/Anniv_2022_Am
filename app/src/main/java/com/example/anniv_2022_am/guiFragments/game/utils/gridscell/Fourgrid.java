package com.example.anniv_2022_am.guiFragments.game.utils.gridscell;

import android.graphics.Rect;

import com.example.anniv_2022_am.guiFragments.game.utils.common.BlinkCell;
import com.example.anniv_2022_am.guiFragments.game.utils.common.Cell;

import java.util.ArrayList;
import java.util.List;

public class Fourgrid extends GridCell {

    public Fourgrid(Rect hitbox) {
        int top = hitbox.top + (hitbox.height()-hitbox.width())/2;
        int left = hitbox.left;
        int sizebox = hitbox.width()/5;

        int cur_top = top+sizebox;
        int cur_left = left+sizebox;
        List<Cell> cells = new ArrayList<>();
        // top
        cells.add(new BlinkCell(new Rect(cur_left, cur_top, cur_left+sizebox, cur_top+sizebox)));
        cells.add(new BlinkCell(new Rect(cur_left+2*sizebox, cur_top, cur_left+3*sizebox, cur_top+sizebox)));
        cur_top += sizebox;
        // mid
        cells.add(new BlinkCell(new Rect(cur_left, cur_top, cur_left+sizebox, cur_top+sizebox)));
        cells.add(new BlinkCell(new Rect(cur_left+sizebox, cur_top, cur_left+2*sizebox, cur_top+sizebox)));
        cells.add(new BlinkCell(new Rect(cur_left+2*sizebox, cur_top, cur_left+3*sizebox, cur_top+sizebox)));
        cur_top += sizebox;
        // bot
        cells.add(new BlinkCell(new Rect(cur_left+2*sizebox, cur_top, cur_left+3*sizebox, cur_top+sizebox)));
        super.setCells(cells);
    }
}
