package com.example.anniv_2022_am.guiFragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.anniv_2022_am.controleurs.Variables;

import java.util.Calendar;

public abstract class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    protected GameEngine gameEngine;

    public GameView(Context context) { super(context); createSurface(); }
    public GameView(Context context, AttributeSet attrs) { super(context, attrs); createSurface(); }
    public GameView(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); createSurface(); }
    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); createSurface(); }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) { }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) { }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) { }

    public void createSurface() {
        this.surfaceHolder = getHolder();
        this.surfaceHolder.addCallback(this);

        setZOrderOnTop(true);
        this.surfaceHolder.setFormat(PixelFormat.TRANSPARENT);
        setKeepScreenOn(true);

        this.setBackgroundColor(Color.YELLOW);

        Log.d(Variables.TAG_Terminal, "Size : " + this.getHeight() + " " + this.getWidth());
    }

    public abstract void init(int height, int width);

    public void update() {
        this.gameEngine.update();
        if(this.gameEngine.haveToReset()) {
            init(this.gameEngine.getHeight(), this.gameEngine.getWidth());
        }
    }

    public Canvas startDraw() {
        // Display the GUI
        Canvas canvas = this.surfaceHolder.lockCanvas();
        if(canvas == null)
            return null;

        // Clear the canvas
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        return canvas;
    }

    public abstract void draw();

    public void endDraw(Canvas canvas) {
        this.surfaceHolder.unlockCanvasAndPost(canvas);
    }
}
