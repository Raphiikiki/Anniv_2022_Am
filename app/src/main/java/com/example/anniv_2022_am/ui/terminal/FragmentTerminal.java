package com.example.anniv_2022_am.ui.terminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.ui.terminal.fragments.FragmentInputTerminal;
import com.example.anniv_2022_am.ui.terminal.fragments.FragmentTextTerminal;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class FragmentTerminal extends Fragment {

    private FragmentManager fragmentManager;
    private TextInputEditText input;
    private FragmentInputTerminal terminal;

    public FragmentTerminal() {
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
        View root = inflater.inflate(R.layout.fragment_navigation_terminal, container, false);

        // Get the input
        this.input = root.findViewById(R.id.input_terminal);

        // Setup the button
        root.findViewById(R.id.btn_validateterminal).setOnClickListener(this::sendText);

        this.replaceFragment(new FragmentTextTerminal());
        return root;
    }

    public void sendText(View view) {
        this.terminal.processData(Objects.requireNonNull(this.input.getText()).toString());
        this.input.getText().clear();
    }

    private void replaceFragment(FragmentInputTerminal fragment) {
        this.terminal = fragment;
        this.fragmentManager.beginTransaction()
                .replace(R.id.layout_prompt, this.terminal)
                .addToBackStack(null)
                .commit();
    }
}