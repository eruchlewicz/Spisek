package com.example.ewelina.spisek;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoFragment extends Fragment {

    DatabaseHelper myDB;
    EditText edit_id;
    Button btnUsun;

    public InfoFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myDB = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        btnUsun = (Button)v.findViewById(R.id.button_delete);
        edit_id = (EditText) v.findViewById(R.id.usun_id);
        Usun();
        return v;
    }

    public void Usun() {
        btnUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDB.deleteData(edit_id.getText().toString());
                        if(deletedRows > 0) Toast.makeText(getActivity(), "Piosenka została usunięta.", Toast.LENGTH_LONG).show();
                        else Toast.makeText(getActivity(), "Piosenka nie została usunięta.", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}