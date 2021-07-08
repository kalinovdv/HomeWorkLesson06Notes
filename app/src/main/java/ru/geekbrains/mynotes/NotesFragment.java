package ru.geekbrains.mynotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class NotesFragment extends Fragment {

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

        Note[] notes = new Note[titels.length];

        for (int i = 0; i < notes.length; i++) {
            notes[i] = new Note(titels[i], texts[i], new Date());

            TextView textView = new TextView(getContext());
            textView.setText(notes[i].getTitel());
            textView.setTextSize(30);
            linearLayout.addView(textView);
        }

    }

}