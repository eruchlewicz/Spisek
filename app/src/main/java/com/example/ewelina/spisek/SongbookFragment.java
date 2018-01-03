package com.example.ewelina.spisek;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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

public class SongbookFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    DatabaseHelper db;
    EditText edit_id;
    Button btnDodaj;
    ListView songbookList;
    String songbook;
    ArrayAdapter<String> dataAdapter;
    String delString;
    List<String> songbooks;

    public SongbookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        btnDodaj = (Button)v.findViewById(R.id.button_add_songbook);
        edit_id = (EditText) v.findViewById(R.id.add_songbook);
        songbookList = (ListView) v.findViewById(R.id.listView);
        songbooks = db.getAllSongbooks();

        loadSpinnerData();
        songbookList.setOnItemSelectedListener(this);

        Dodaj();

        songbookList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View v, final int position,final long id) {
                final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(getActivity());

                dialogDelete.setTitle("Uwaga");
                dialogDelete.setMessage("Czy na pewno chcesz usunąć ten śpiewnik?");
                dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delString = songbooks.get(Integer.valueOf(String.valueOf(id)));
                        if(delString.length()!=0){
                            db.deleteSongbook(delString);
                            if(db.deleteSongbook(delString) == 0) Toast.makeText(getContext(), "Śpiewnik został usunięty.", Toast.LENGTH_LONG).show();
                            dataAdapter.remove(dataAdapter.getItem(position));
                            dataAdapter.notifyDataSetChanged();
                        }
                    }
                });

                dialogDelete.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogDelete.show();

                return true;
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        songbook = songbookList.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void loadSpinnerData() {

        songbooks = db.getAllSongbooks();

        dataAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_selectable_list_item, songbooks);

        songbookList.setAdapter(dataAdapter);
    }

    public void Dodaj() {
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( edit_id.getText().toString().length() == 0 )
                    edit_id.setError( "Tytuł jest wymagany!" );

                if( edit_id.getText().toString().length() > 0)
                {
                    boolean isInserted = db.insertSongbook(edit_id.getText().toString());
                    if(isInserted == true) {
                        loadSpinnerData();
                        Toast.makeText(getActivity(), "Śpiewnik został dodany.", Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(getActivity(), "Śpiewnik nie został dodany.", Toast.LENGTH_LONG).show();}
                edit_id.setText(delString, TextView.BufferType.EDITABLE);
            }
        });
    }
}