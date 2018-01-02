package com.example.ewelina.spisek;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class SongbookFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    DatabaseHelper myDB;
    EditText edit_id;
    Button btnDodaj;
    ListView songbookList;
    String songbook;

    public SongbookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myDB = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        btnDodaj = (Button)v.findViewById(R.id.button_add_songbook);
        edit_id = (EditText) v.findViewById(R.id.add_songbook);
        songbookList = (ListView) v.findViewById(R.id.listView);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.songbooks, android.R.layout.simple_selectable_list_item);
        songbookList.setAdapter(adapter);
        songbookList.setOnItemSelectedListener(this);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        songbook = songbookList.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}