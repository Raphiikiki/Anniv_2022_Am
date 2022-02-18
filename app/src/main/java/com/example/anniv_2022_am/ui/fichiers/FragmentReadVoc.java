package com.example.anniv_2022_am.ui.fichiers;

import android.app.Fragment;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.Variables;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentReadVoc extends Fragment {

    private MediaPlayer player;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_read_voc, container, false);
        String fichier = getArguments().getString("fichier");

        Log.d(Variables.TAG_Fichiers, "Fichier : " + fichier + ", chemin : fichiers/" + fichier);

        // Load the file
        try {
            AssetFileDescriptor afd = getContext().getAssets().openFd("fichiers/"+fichier);
            this.player = new MediaPlayer();
            this.player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            this.player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.findViewById(R.id.btn_play).setOnClickListener(view -> {
            if(!player.isPlaying()) {
                player.start();
            }
        });
        root.findViewById(R.id.btn_pause).setOnClickListener(view -> {
            if(player.isPlaying()) {
                player.pause();
            }
        });
        root.findViewById(R.id.btn_replay).setOnClickListener(view -> {
            player.seekTo(0);
        });

        // Setup the progressbar
        ProgressBar pb = root.findViewById(R.id.pb_vocal);
        pb.setMax(100);

        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                // Update the progress bar
                float progress = ((float) player.getCurrentPosition() /player.getDuration()) * 100;

                pb.setProgress((int) progress);

                // For garbage collection
                System.gc();
            }

        }, 0, 16);

        this.player.start();

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
        this.player.stop();
    }
}
