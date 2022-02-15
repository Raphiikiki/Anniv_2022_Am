package com.example.anniv_2022_am.ui.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.modele.Fichier;

import java.util.List;

public class NotificationsAdapter extends ArrayAdapter<Fichier> {

    public NotificationsAdapter(Context context, List<Fichier> fichiers) {
        super(context, 0, fichiers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Fichier picture = getItem(position);

        // Override the view to avoid cross references
        View notifView = LayoutInflater.from(getContext()).inflate(R.layout.layout_notification, parent, false);


        // Set up the associated data
        if(picture != null) {
            ((TextView)notifView.findViewById(R.id.txtview_title)).setText(picture.getNom());
            ((TextView)notifView.findViewById(R.id.txtview_date)).setText(picture.getSDate());
            ((TextView)notifView.findViewById(R.id.txtview_notiftext)).setText(picture.getDesc());
        }

        // Return the completed view to render on screen
        return notifView;
    }

}
