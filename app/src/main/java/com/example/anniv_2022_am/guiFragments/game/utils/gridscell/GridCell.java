package com.example.anniv_2022_am.guiFragments.game.utils.gridscell;

import android.graphics.Canvas;

import com.example.anniv_2022_am.guiFragments.game.utils.common.Cell;

import java.util.ArrayList;
import java.util.List;

public class GridCell {

    public List<Cell> cells;

    public GridCell() {
        this(new ArrayList<>());
    }

    public GridCell(List<Cell> cells) {
        this.cells = cells;
    }

    protected void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void draw(Canvas canvas) {
        for(Cell cell : this.cells) {
            cell.draw(canvas);
        }
    }

    public void update() {
        for(Cell cell : this.cells) {
            cell.update();
        }
    }
}
