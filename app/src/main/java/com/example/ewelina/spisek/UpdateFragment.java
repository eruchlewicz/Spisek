package com.example.ewelina.spisek;

/**
 * Created by Ewelina on 2017-12-29.
 */

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class UpdateFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    ArrayList<Song> songs;
    DatabaseHelper db;
    EditText editTitle, editPage, editNr, editLyrics, editChords;
    Spinner songbook;
    Button btnZaktualizuj, btnAnuluj;
    public Integer selected=null;

    public static UpdateFragment newInstance(){
        UpdateFragment fragment = new UpdateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View rootView =  inflater.inflate(R.layout.fragment_update, parent, false);

        editTitle = (EditText)rootView.findViewById(R.id.editText_title);
        editPage = (EditText)rootView.findViewById(R.id.editText_page);
        editNr = (EditText)rootView.findViewById(R.id.editText_nr);
        editLyrics = (EditText)rootView.findViewById(R.id.editText_lyrics);
        editChords = (EditText)rootView.findViewById(R.id.editText_chords);
        songbook = (Spinner)rootView.findViewById(R.id.songbook);
        btnZaktualizuj = (Button)rootView.findViewById(R.id.button_update);
        btnAnuluj= (Button)rootView.findViewById(R.id.button_cancel);

        Zaktualizuj();
        Anuluj();

        Bundle bundle = this.getArguments();
        if(bundle != null){
            selected = bundle.getInt("selected_id");
        }

        db = new DatabaseHelper(getContext());

        loadSpinnerData();
        songbook.setOnItemSelectedListener(this);

        songs = db.getData();
        Song song = songs.get(selected);
        selected = Integer.valueOf(song.getId());

        editTitle.setText(song.getTitle(), TextView.BufferType.EDITABLE);
        editPage.setText(song.getPage(), TextView.BufferType.EDITABLE);
        editNr.setText(song.getNumber(), TextView.BufferType.EDITABLE);
        editLyrics.setText(song.getLyrics(), TextView.BufferType.EDITABLE);
        editChords.setText(song.getChords(), TextView.BufferType.EDITABLE);
        songbook.setSelection(((ArrayAdapter<String>) songbook.getAdapter()).getPosition(song.getSongbook()));

        return rootView;
    }

    public void Zaktualizuj() {
        btnZaktualizuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regexStr = "^[0-9]*$";
                if (!editPage.getText().toString().trim().matches(regexStr))
                    editPage.setError("Podaj stronę");
                if (!editNr.getText().toString().trim().matches(regexStr))
                    editNr.setError("Podaj numer");
                if (editTitle.getText().toString().length() == 0)
                    editTitle.setError("Tytuł jest wymagany!");
                if (editPage.getText().toString().length() == 0 && editNr.getText().toString().length() == 0 )
                    editTitle.setError("Wpisz stronę lub numer!");
                //if(songbook.getSelectedItem().toString().length() == 0 )
                    //Toast.makeText(getActivity(), "Wybierz śpiewnik!", Toast.LENGTH_LONG).show();

                if (editTitle.getText().toString().length() > 0 && songbook.getSelectedItem().toString().length() > 0
                        && editPage.getText().toString().trim().matches(regexStr) && editNr.getText().toString().trim().matches(regexStr)
                        && (editPage.getText().toString().length() != 0 || editNr.getText().toString().length() != 0)) {
                    int isUpdated = db.updateData(selected, editTitle.getText().toString(), songbook.getSelectedItem().toString(),
                            editPage.getText().toString(), editNr.getText().toString(), editLyrics.getText().toString(),
                            editChords.getText().toString());

                    if (isUpdated > 0)
                        Toast.makeText(getActivity(), "Piosenka została zaktualizowana.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity(), "Piosenka nie została zaktualizowana.", Toast.LENGTH_LONG).show();

                    Fragment fragment = new SearchFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction
                            .replace(R.id.main_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }

    public void Anuluj() {
        btnAnuluj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new SearchFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.main_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void loadSpinnerData() {

        List<String> songbooks = db.getAllSongbooks();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, songbooks);

        songbook.setAdapter(dataAdapter);
    }

}
