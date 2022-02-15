package com.example.anniv_2022_am.modele;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fichier {

    private String nom;
    private Date date;
    private String path;

    public Fichier(String nom, Date date, String path) {
        this.nom = nom;
        this.date = date;
        this.path = path;
    }

    public Fichier(String nom, String date, String path) throws ParseException {
        this(nom, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.FRANCE).parse(date), path);
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getPath() {
        return path;
    }

    @Override
    @NonNull
    public String toString() {
        return "Fichier{" +
                "nom='" + nom + '\'' +
                ", date=" + date +
                ", path='" + path + '\'' +
                '}';
    }
}
