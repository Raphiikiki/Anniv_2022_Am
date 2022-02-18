package com.example.anniv_2022_am.ui.terminal.fragments;

import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.GCommandes;
import com.example.anniv_2022_am.modele.Commandes;

import java.lang.reflect.InvocationTargetException;

public class FragmentTextTerminal extends FragmentInputTerminal {

    private TextView logs;
    private ScrollView sv;

    public FragmentTextTerminal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_text_terminal, container, false);

        this.logs = root.findViewById(R.id.txtview_textterminal);
        this.logs.setText(R.string.welcome_text_terminal);
        this.sv = root.findViewById(R.id.sv_textterminal);
        return root;
    }

    @Override
    public boolean processData(String data) {
        super.processData(data);
        this.printCommand(data);
        String result = GCommandes.applyCommand(data);
        this.printResult(result);
        this.sv.fullScroll(View.FOCUS_DOWN);
        return result.equals(Commandes.swap(null));
    }

    private void printCommand(String command) {
        this.printData("> " + command);
    }

    private void printResult(String result) {
        this.printData(result);
    }
    private void printData(String data) {
        this.logs.append(data + "\n");
    }
}