package ru.geekbrains.mynotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

public class TextOfNoteFragment extends Fragment {

    public static final String ARG_NOTE = "note";
    private Note note;

    public static TextOfNoteFragment newInstance(Note note) {
        TextOfNoteFragment fragment = new TextOfNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_of_note, container, false);

        TextView textOfNote = view.findViewById(R.id.textOfNote);
        TextView titleOfNote = view.findViewById(R.id.titleOfNote);
        DatePicker dateOfNote = view.findViewById(R.id.dateOfNote);

        textOfNote.setText(note.getText());
        titleOfNote.setText(note.getTitel());

        return view;
    }
}