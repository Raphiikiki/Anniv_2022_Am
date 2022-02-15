package com.example.anniv_2022_am.ui.terminal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anniv_2022_am.R;

public class FragmentGraphiqueTerminal extends FragmentInputTerminal {

    public FragmentGraphiqueTerminal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graphique_terminal, container, false);
    }
}