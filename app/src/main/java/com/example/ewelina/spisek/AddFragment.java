package com.example.ewelina.spisek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFragment extends Fragment {

    DatabaseHelper myDB;
    EditText editTitle, editPlace, editPage, editNr, editLyrics;
    Button btnDodaj;
    Button btnWyswietl;

    public AddFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myDB = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        editTitle = (EditText)v.findViewById(R.id.editText_title);
        editPlace = (EditText)v.findViewById(R.id.editText_place);
        editPage = (EditText)v.findViewById(R.id.editText_page);
        editNr = (EditText)v.findViewById(R.id.editText_nr);
        editLyrics = (EditText)v.findViewById(R.id.editText_lyrics);
        btnDodaj = (Button)v.findViewById(R.id.button_add);
        btnWyswietl = (Button)v.findViewById(R.id.button_view);
        Dodaj();
        return v;
    }

    public void Dodaj() {
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editTitle.getText().toString(), editPlace.getText().toString(), editPage.getText().toString(),
                        editNr.getText().toString(), editLyrics.getText().toString());
            }
        });
    }
}