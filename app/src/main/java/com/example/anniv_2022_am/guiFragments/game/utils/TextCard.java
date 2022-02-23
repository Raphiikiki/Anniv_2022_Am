package com.example.anniv_2022_am.guiFragments.game.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class TextCard {

    private Rect card;
    private String text;
    private Paint paint_rect;
    private Paint paint_text;

    public TextCard(Rect card, String text) {
        this(card, text, new Paint(), new Paint());
        this.paint_rect.setColor(Color.DKGRAY);
        this.paint_text.setColor(Color.WHITE);
        this.paint_text.setTextSize(card.height()/4);
        this.paint_text.setAntiAlias(true);
        this.paint_text.setTextAlign(Paint.Align.CENTER);
    }

    public TextCard(Rect card, String text, Paint paint_rect, Paint paint_text) {
        this.card = card;
        this.text = text;
        this.paint_rect = paint_rect;
        this.paint_text = paint_text;
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(this.card, this.paint_rect);
        this.paint_text.getTextBounds(this.text, 0, this.text.length(), new Rect());
        int pos = (int) (this.card.centerY() - ((this.paint_text.descent() + this.paint_text.ascent()) / 2));
        canvas.drawText(this.text, this.card.centerX(), pos, this.paint_text);
    }

    public void offset(int x, int y) {
        this.card.offset(x, y);
    }

    public Rect getCard() {
        return card;
    }

    public void setCard(Rect card) {
        this.card = card;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Paint getPaint_rect() {
        return paint_rect;
    }

    public void setPaint_rect(Paint paint_rect) {
        this.paint_rect = paint_rect;
    }

    public Paint getPaint_text() {
        return paint_text;
    }

    public void setPaint_text(Paint paint_text) {
        this.paint_text = paint_text;
    }

    public void changeColorRect(int color) { this.paint_rect.setColor(color); }

    public void changeColorText(int color) { this.paint_text.setColor(color); }
}
