package com.example.anniv_2022_am.ui.terminal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.GCommandesGUI;
import com.example.anniv_2022_am.guiFragments.Game;
import com.example.anniv_2022_am.guiFragments.GameView;
import com.example.anniv_2022_am.guiFragments.game.error.ErrorCommand;
import com.example.anniv_2022_am.modele.CommandesGUI;

public class FragmentGraphiqueTerminal extends FragmentInputTerminal {

    private FragmentManager fragmentManager;
    private Game game;

    public FragmentGraphiqueTerminal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fragmentManager = getChildFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_graphique_terminal, container, false);
        replaceFragment(new ErrorCommand(getContext()));
        return root;
    }

    @Override
    public boolean processData(String data) {
        super.processData(data);
        Fragment result = GCommandesGUI.applyCommand(data);
        return result == CommandesGUI.swap(null);
    }

    private void replaceFragment(GameView gameView) {
        this.game = new Game(gameView);
        this.fragmentManager.beginTransaction()
                .replace(R.id.view_guiterminal, this.game)
                .addToBackStack(null)
                .commit();
    }
}