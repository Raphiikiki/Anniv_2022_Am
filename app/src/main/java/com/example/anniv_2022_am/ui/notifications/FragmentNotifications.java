package com.example.anniv_2022_am.ui.notifications;

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

public class FragmentNotifications extends Fragment {

    private GridView gridView;
    private NotificationsAdapter notificationsAdapter;

    public FragmentNotifications() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(Variables.TAG_Notifications, "OnCreate() notification fragment");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Variables.TAG_Notifications, "OnCreateView() notification fragment");

        View root = inflater.inflate(R.layout.fragment_navigation_notifications, container, false);
        // Load all component to load the pictures
        this.gridView = root.findViewById(R.id.gridview_notifications);
        this.notificationsAdapter = new NotificationsAdapter(gridView.getContext(), GFichiers.getFichiers());
        this.gridView.setAdapter(this.notificationsAdapter);
        // Inflate the layout for this fragment
        return root;
    }
}