package com.example.anniv_2022_am.guiFragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.Variables;

import java.util.Timer;
import java.util.TimerTask;

public class Game extends Fragment {

    private GameView gameView;
    private static ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private Timer timer;

    public Game() { }

    public Game(GameView gameView) {
        this.gameView = gameView;
        this.gameView.setLayoutParams(Game.layoutParams);
        this.timer = new Timer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.layout_gameview, container, false);
        ((ConstraintLayout)root).removeAllViews();
        ((ConstraintLayout)root).addView(this.gameView);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);

                Log.d(Variables.TAG_Terminal, "Size of GUI : " + getView().getHeight() + " " + getView().getWidth());
                gameView.init(getView().getHeight(), getView().getWidth());
                startGame();
            }
        });
    }

    private void startGame() {
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                // Update the GUI
                gameView.draw();
                gameView.update();

                // For garbage collection
                System.gc();
            }

        }, 0, 16);
    }

}
