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
    private String desc;
    private String path;

    public Fichier(String nom, Date date, String desc, String path) {
        this.nom = nom;
        this.date = date;
        this.desc = desc;
        this.path = path;
    }

    public Fichier(String nom, String date, String desc, String path) throws ParseException {
        this(nom, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.FRANCE).parse(date), desc, path);
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getSDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm", Locale.FRANCE);
        return simpleDateFormat.format(this.date);
    }

    public String getDesc() { return desc; }

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
