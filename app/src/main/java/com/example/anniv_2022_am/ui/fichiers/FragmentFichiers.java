package com.example.anniv_2022_am.ui.fichiers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.GFichiers;
import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.ui.notifications.NotificationsAdapter;

public class FragmentFichiers extends Fragment {

    private GridView gridView;
    private FichiersAdapter fichiersAdapter;

    public FragmentFichiers() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(Variables.TAG_Notifications, "OnCreate() fichiers fragment");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_navigation_fichiers, container, false);

        // Load all component to load the pictures
        this.gridView = root.findViewById(R.id.gridview_fichiers);
        this.fichiersAdapter = new FichiersAdapter(gridView.getContext(), GFichiers.getFichiers());
        this.gridView.setAdapter(this.fichiersAdapter);

        return root;
    }
}