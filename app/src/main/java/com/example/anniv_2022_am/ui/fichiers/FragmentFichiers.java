package com.example.anniv_2022_am.ui.fichiers;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.example.anniv_2022_am.DisplayStuff;
import com.example.anniv_2022_am.MainActivity;
import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.GFichiers;
import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.modele.Fichier;
import com.example.anniv_2022_am.ui.notifications.NotificationsAdapter;

import java.util.List;

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

        // Data
        List<Fichier> fichiers = GFichiers.getFichiers();

        // Load all component to load the pictures
        this.gridView = root.findViewById(R.id.gridview_fichiers);
        this.fichiersAdapter = new FichiersAdapter(gridView.getContext(), fichiers);
        this.gridView.setAdapter(this.fichiersAdapter);

        this.gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            // set an Intent to Another Activity
            Fichier fichier = fichiers.get(position);
            Log.d(Variables.TAG_Fichiers, fichier.toString());
            Intent intent = new Intent(getActivity(), DisplayStuff.class);
            intent.putExtra("fichier", fichier.getNom());
            intent.putExtra("ext", fichier.getExt());
            startActivity(intent); // start Intent
        });

        return root;
    }
}