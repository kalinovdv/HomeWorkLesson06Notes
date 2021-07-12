package ru.geekbrains.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class TextOfNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_of_note);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            TextOfNoteFragment textOfNoteActivity = new TextOfNoteFragment();
            textOfNoteActivity.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.textOfNote, textOfNoteActivity).commit();
        }
    }
}