package com.example.anniv_2022_am.ui.fichiers;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.Utils;
import com.example.anniv_2022_am.modele.Fichier;

import java.util.List;

public class FichiersAdapter extends ArrayAdapter<Fichier> {

    public FichiersAdapter(Context context, List<Fichier> fichiers) {
        super(context, 0, fichiers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Fichier fichier = getItem(position);

        // Override the view to avoid cross references
        View notifView = LayoutInflater.from(getContext()).inflate(R.layout.layout_fichiers, parent, false);

        // Set up the associated data
        if(fichier != null) {
            String fullPath = "icones/"+fichier.getNom();
            ((ImageView)notifView.findViewById(R.id.imageview_fichier)).setImageBitmap(Utils.getBitmapFromAssets(getContext(), fullPath));
        }

        // Return the completed view to render on screen
        return notifView;
    }
}
