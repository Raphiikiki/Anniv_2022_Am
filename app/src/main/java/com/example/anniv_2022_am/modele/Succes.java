package com.example.anniv_2022_am.modele;

public class Succes {

    private String nom;
    private boolean done;
    private String desc;

    public Succes(String nom, boolean done, String desc) {
        this.nom = nom;
        this.done = done;
        this.desc = desc;
    }

    public String getNom() {
        return nom;
    }

    public boolean isDone() {
        return done;
    }

    public String getDesc() {
        return desc;
    }

    public void setDone() {
        this.done = true;
    }
}
