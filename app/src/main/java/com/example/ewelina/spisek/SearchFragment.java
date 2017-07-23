package com.example.ewelina.spisek;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchFragment extends Fragment {

    DatabaseHelper myDB;
    Button btnWyswietl;

    public SearchFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myDB = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        btnWyswietl = (Button)v.findViewById(R.id.button_view);
        Wyswietl();
        return v;
    }

    public void Wyswietl() {
        btnWyswietl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDB.viewData();
                if(res.getCount() == 0) {
                    showMessage("Błąd", "Nic nie znaleziono.");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Id: " + res.getString(0) + "\n");
                    buffer.append("Tytuł: " + res.getString(1) + "\n");
                    buffer.append("Śpiewnik: " + res.getString(2) + "\n");
                    buffer.append("Strona: " + res.getString(3) + "\n");
                    buffer.append("Nr: " + res.getString(4) + "\n");
                    buffer.append("Słowa: " + res.getString(5) + "\n\n");
                }
                showMessage("Dane", buffer.toString());
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
}