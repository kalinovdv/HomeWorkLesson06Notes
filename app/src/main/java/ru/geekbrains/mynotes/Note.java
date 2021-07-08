package ru.geekbrains.mynotes;

import java.util.Date;

public class Note {
    private String titel;
    private String text;
    private Date date;

    public Note(String titel, String text, Date date) {
        this.titel = titel;
        this.text = text;
        this.date = date;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
