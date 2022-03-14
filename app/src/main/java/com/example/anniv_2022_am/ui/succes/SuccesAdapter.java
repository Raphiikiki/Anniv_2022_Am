package com.example.anniv_2022_am.ui.succes;

import android.content.Context;
import android.util.Log;
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
import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.modele.Fichier;
import com.example.anniv_2022_am.modele.Succes;

import java.util.List;

public class SuccesAdapter extends ArrayAdapter<Succes> {

    public SuccesAdapter(Context context, List<Succes> succes) { super(context, 0, succes); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Succes succes = getItem(position);

        // Override the view to avoid cross references
        View succesView = LayoutInflater.from(getContext()).inflate(R.layout.layout_succes, parent, false);

        // Set up the associated data
        if(succes != null) {
            Log.d(Variables.TAG_Succes, "Succes : " + succes);
            if(succes.isDone()) {
                ((ImageView)succesView.findViewById(R.id.imgview_succes)).setImageResource(android.R.drawable.btn_star_big_on);
                Log.d(Variables.TAG_Succes, "Succes is done");
            }
            ((TextView)succesView.findViewById(R.id.txtview_nomsucces)).setText(succes.getNom());
            ((TextView)succesView.findViewById(R.id.txtview_descsucces)).setText(succes.getDesc());
        }

        // Return the completed view to render on screen
        return succesView;
    }
}
