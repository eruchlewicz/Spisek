package com.example.ewelina.spisek;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ListView listView;
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
        editSearchTitle = (EditText) v.findViewById(R.id.title_filter);
        spinner = (Spinner) v.findViewById(R.id.search_place);
        listView = (ListView) v.findViewById(R.id.listView);

        loadSpinnerData();
        spinner.setOnItemSelectedListener(this);

        db = new DatabaseHelper(getContext());
        songs = db.getData();
        adapter= new ListAdapter(getContext(),R.layout.row_item,songs);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View v, final int position, long id) {

                CharSequence[] items = {"Edytuj", "Usuń"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

                dialog.setTitle("Wybierz akcję");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            // update
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
                        else {
                            // delete
                            final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(getActivity());

                            dialogDelete.setTitle("Uwaga");
                            dialogDelete.setMessage("Czy na pewno chcesz usunąć tę piosenkę?");
                            dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Song song = songs.get(position);
                                    db.deleteData(Integer.valueOf(song.getId()));
                                    if(db.deleteData(Integer.valueOf(song.getId())) == 0) Toast.makeText(getContext(), "Piosenka została usunięta.", Toast.LENGTH_LONG).show();
                                    adapter.remove(adapter.getItem(position));
                                    adapter.notifyDataSetChanged();
                                }
                            });

                            dialogDelete.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            dialogDelete.show();
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        editSearchTitle.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0) {
                    String songbook = spinner.getSelectedItem().toString();
                    String songTitle = editSearchTitle.getText().toString();
                    songs = db.getFilteredData(songTitle, songbook);
                    adapter= new ListAdapter(getContext(),R.layout.row_item,songs);
                    listView.setAdapter(adapter);
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String songbook = spinner.getSelectedItem().toString();
                String songTitle = editSearchTitle.getText().toString();
                songs = db.getFilteredData(songTitle, songbook);
                adapter= new ListAdapter(getContext(),R.layout.row_item,songs);
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selected_id = position;
                Song song = songs.get(selected_id);
                selected_id = Integer.valueOf(song.getId());
                String title = "";
                Cursor res = db.viewData();
                if(res.getCount() == 0) {
                    showMessage("Błąd", "Nic nie znaleziono.");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    if((res.getInt(0)==selected_id)) {
                        title = res.getString(1);
                        if(res.getString(6).length()!=0) {
                            buffer.append("Akordy: \n" + res.getString(6) + "\n");}
                        buffer.append("\n");
                    }
                }
                showMessage(title, buffer.toString());
            }
        });

        return v;
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