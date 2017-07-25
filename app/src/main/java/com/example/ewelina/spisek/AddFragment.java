package com.example.ewelina.spisek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    DatabaseHelper myDB;
    EditText editTitle, editPage, editNr, editLyrics, editChords;
    Button btnDodaj;
    Spinner spinner2;

    public AddFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myDB = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        editTitle = (EditText)v.findViewById(R.id.editText_title);
        spinner2 = (Spinner)v.findViewById(R.id.spinner2);
        editPage = (EditText)v.findViewById(R.id.editText_page);
        editNr = (EditText)v.findViewById(R.id.editText_nr);
        editLyrics = (EditText)v.findViewById(R.id.editText_lyrics);
        editChords = (EditText) v.findViewById(R.id.editText_chords);
        btnDodaj = (Button)v.findViewById(R.id.button_add);
        Dodaj();
        spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.songbooks, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        return v;
    }

    public void Dodaj() {
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regexStr = "^[0-9]*$";
                if(!editPage.getText().toString().trim().matches(regexStr))
                    editPage.setError( "Podaj numer strony" );
                if( editTitle.getText().toString().length() == 0 )
                    editTitle.setError( "Tytuł jest wymagany!" );
                if( spinner2.getSelectedItem().toString().length() == 0 )
                    Toast.makeText(getActivity(), "Wybierz śpiewnik!", Toast.LENGTH_LONG).show();
                if( editPage.getText().toString().length() == 0 )
                    editPage.setError( "Podaj stronę" );

                if( editPage.getText().toString().length() > 0 && spinner2.getSelectedItem().toString().length() > 0
                        && editPage.getText().toString().length() > 0 && editPage.getText().toString().trim().matches(regexStr))
                {

                boolean isInserted = myDB.insertData(editTitle.getText().toString(), spinner2.getSelectedItem().toString(), editPage.getText().toString(),
                        editNr.getText().toString(), editLyrics.getText().toString(), editChords.getText().toString());
                if(isInserted == true) Toast.makeText(getActivity(), "Piosenka została dodana.", Toast.LENGTH_LONG).show();
                else Toast.makeText(getActivity(), "Piosenka nie została dodana.", Toast.LENGTH_LONG).show();}
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}