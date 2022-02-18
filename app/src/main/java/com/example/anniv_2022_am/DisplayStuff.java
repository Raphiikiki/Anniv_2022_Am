package com.example.anniv_2022_am;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.anniv_2022_am.controleurs.Variables;
import com.example.anniv_2022_am.ui.fichiers.FragmentReadPDF;
import com.example.anniv_2022_am.ui.fichiers.FragmentReadVoc;
import com.example.anniv_2022_am.ui.terminal.fragments.FragmentInputTerminal;

public class DisplayStuff extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stuff);

        Intent intent = getIntent(); // get Intent which we set from Previous Activity

        fragment = new Fragment();
        Bundle bundle = new Bundle();

        Log.d(Variables.TAG_Fichiers, "Extension : " + intent.getStringExtra("ext"));
        switch (intent.getStringExtra("ext")) {
            case ".pdf":
                fragment = new FragmentReadPDF();
                bundle.putString("fichier", intent.getStringExtra("fichier"));
                break;
            case ".mp3":
                fragment = new FragmentReadVoc();
                bundle.putString("fichier", intent.getStringExtra("fichier"));
                break;
        }

        fragment.setArguments(bundle);
        this.replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.view_readfile, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        //this.onDestroy();
    }
}