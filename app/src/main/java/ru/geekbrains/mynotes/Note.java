package ru.geekbrains.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private String titel;
    private String text;
    private Date date;

    public Note() {
        this.titel = "";
        this.text = "";
        this.date = new Date();
    }

    public Note(String titel, String text, Date date) {
        this.titel = titel;
        this.text = text;
        this.date = date;
    }

    protected Note(Parcel in) {
        this.titel = in.readString();
        this.text = in.readString();
        long tmp = in.readLong();
        this.date = tmp == -1 ? null : new Date(tmp);
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titel);
        dest.writeString(this.text);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
