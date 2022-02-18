package com.example.anniv_2022_am.ui.terminal.fragments;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.anniv_2022_am.controleurs.Variables;

public abstract class FragmentInputTerminal extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean processData(String data) {
        Log.d(Variables.TAG_Terminal, data);
        return false;
    }
}
