package com.example.anniv_2022_am.ui.fichiers;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.anniv_2022_am.R;
import com.example.anniv_2022_am.controleurs.Variables;
import com.github.barteksc.pdfviewer.PDFView;

public class FragmentReadPDF extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_read_pdf, container, false);
        String fichier = getArguments().getString("fichier");

        ((PDFView)root.findViewById(R.id.pdfview_fichier)).fromAsset("fichiers/"+fichier).enableSwipe(true) /* allows to block changing pages using swipe*/
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .load();
        Log.d(Variables.TAG_Fichiers, "Fichier : " + fichier + ", chemin : fichiers/" + fichier);
        return root;
    }
}
