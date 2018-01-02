package com.example.ewelina.spisek;

import android.database.Cursor;
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
import java.util.Random;

public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ListView recycler;
    private ListAdapter adapter;
    ArrayList<Song> songs;
    Cursor cursor;
    public Integer selected_id = null;
    DatabaseHelper db;
    EditText editSearchTitle;
    Button btnWyswietl;
    Spinner spinner;
    String songbook;

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        btnWyswietl = (Button)v.findViewById(R.id.button_view);
        editSearchTitle = (EditText) v.findViewById(R.id.title_filter);
        spinner = (Spinner) v.findViewById(R.id.search_place);

        loadSpinnerData();
        spinner.setOnItemSelectedListener(this);

        Wyswietl();

        db = new DatabaseHelper(getContext());
        songs = db.getData();
        adapter= new ListAdapter(getContext(),R.layout.row_item,songs);
        recycler = (ListView) v.findViewById(R.id.listView);
        recycler.setAdapter(adapter);

        recycler.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
                Song song = songs.get(position);
                db.deleteData(Integer.valueOf(song.getId()));
                if(db.deleteData(Integer.valueOf(song.getId())) == 0) Toast.makeText(getContext(), "Piosenka została usunięta.", Toast.LENGTH_LONG).show();
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        recycler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selected_id = position;
                Bundle bundle = new Bundle();
                bundle.putInt("selected_id",selected_id);
                UpdateFragment fragment = new UpdateFragment();
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.main_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

    public void Wyswietl() {
        btnWyswietl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.viewData();
                if(res.getCount() == 0) {
                    showMessage("Błąd", "Nic nie znaleziono.");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    if((res.getString(1).toLowerCase().contains(editSearchTitle.getText().toString().toLowerCase())
                            || res.getString(5).toLowerCase().contains(editSearchTitle.getText().toString().toLowerCase()))
                            && res.getString(2).contains(songbook)) {
                        buffer.append("Id: " + res.getString(0) + "\n");
                        buffer.append("Tytuł: " + res.getString(1) + "\n");
                        buffer.append("Śpiewnik: " + res.getString(2) + "\n");
                        if(res.getString(3).length()!=0) {
                            buffer.append("Strona: " + res.getString(3) + "\n");}
                        if(res.getString(4).length()!=0) {
                            buffer.append("Nr: " + res.getString(4) + "\n");}
                        //buffer.append("Słowa: " + res.getString(5) + "\n\n");
                        if(res.getString(6).length()!=0) {
                            buffer.append("Akordy: " + res.getString(6) + "\n");}
                        buffer.append("\n");
                    }
                }
                showMessage("Znalezione utwory:", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        songbook = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void loadSpinnerData() {

        List<String> songbooks = db.getAllSongbooks();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, songbooks);

        spinner.setAdapter(dataAdapter);
    }
}