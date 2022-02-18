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

    public Fichier(String nom, Date date, String desc) {
        this.nom = nom;
        this.date = date;
        this.desc = desc;
    }

    public Fichier(String nom, String date, String desc) throws ParseException {
        this(nom, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.FRANCE).parse(date), desc);
    }

    public String getNom() {
        return nom;
    }

    public String getNomWoutExt() {
        int dotIndex = this.nom.lastIndexOf('.');
        return (dotIndex == -1) ? this.nom : this.nom.substring(0, dotIndex);
    }

    public String getExt() {
        return this.nom.substring(this.nom.lastIndexOf("."));
    }

    public Date getDate() {
        return date;
    }

    public String getSDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm", Locale.FRANCE);
        return simpleDateFormat.format(this.date);
    }

    public String getDesc() { return desc; }

    @NonNull
    @Override
    public String toString() {
        return "Fichier{" +
                "nom='" + nom + '\'' +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                '}';
    }
}
