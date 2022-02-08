package com.example.anniv_2022_am.modele;

import java.time.LocalDateTime;
import java.util.Date;

public class Notification {

    private String titre;
    private LocalDateTime date;
    private String type;

    public Notification(String titre, LocalDateTime date, String type) {
        this.titre = titre;
        this.date = date;
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
