package com.example.anniv_2022_am.ui.succes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.GSucces;
import com.example.anniv_2022_am.modele.Succes;

import java.util.List;

public class FragmentSucces extends Fragment {

    private GridView gridView;
    private SuccesAdapter succesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_navigation_succes, container, false);

        // Data
        List<Succes> succes = GSucces.getSucces();

        // Load all component to load the pictures
        this.gridView = root.findViewById(R.id.gridview_succes);
        this.succesAdapter = new SuccesAdapter(gridView.getContext(), succes);
        this.gridView.setAdapter(this.succesAdapter);
        return root;
    }
}