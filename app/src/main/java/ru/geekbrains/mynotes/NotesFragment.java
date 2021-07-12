package ru.geekbrains.mynotes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class NotesFragment extends Fragment {

    public static final String CURRENT_NOTE = "CurrentNote";
    private Note currentNote;
    private boolean isLandsape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout)view;

        String[] titels = getResources().getStringArray(R.array.titels);
        String[] texts = getResources().getStringArray(R.array.texts);

        for (int i = 0; i < titels.length; i++) {
            String titel = titels[i];
            TextView textView = new TextView(getContext());
            textView.setText(titel);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            final int j = i;
            textView.setOnClickListener(v -> {
                currentNote = new Note(titel, texts[j], new Date());
                showTextOfNote(currentNote);
            });
        }

    }

    private void showTextOfNote(Note note) {
        if (isLandsape) {
            showLandscapeNote(note);
        } else {
            showPortretNote(note);
        }
    }

    private void showLandscapeNote(Note note) {
        TextOfNoteFragment textOfNoteFragment = TextOfNoteFragment.newInstance(note);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.textOfNote, textOfNoteFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void showPortretNote(Note note) {
        Intent intent = new Intent();
        intent.setClass(getContext(), TextOfNoteActivity.class);
        intent.putExtra(TextOfNoteFragment.ARG_NOTE, note);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(CURRENT_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        } else {
            currentNote = new Note(getResources().getStringArray(R.array.titels)[0], getResources().getStringArray(R.array.texts)[0], new Date());
        }

        isLandsape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (isLandsape) {
            showLandscapeNote(currentNote);
        }
    }
}