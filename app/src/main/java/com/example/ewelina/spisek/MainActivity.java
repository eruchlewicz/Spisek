package com.example.ewelina.spisek;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    DatabaseHelper myDB;
    EditText editTitle, editPlace, editPage, editNr, editLyrics, editTextId;
    Button btnDodaj;
    Button btnWyswietl;
    Button btnAktualizuj;
    Button btnUsun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#999999"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        myDB = new DatabaseHelper(this);
        editTitle = (EditText)findViewById(R.id.editText_title);
        editPlace = (EditText)findViewById(R.id.editText_place);
        editPage = (EditText)findViewById(R.id.editText_page);
        editNr = (EditText)findViewById(R.id.editText_nr);
        editLyrics = (EditText)findViewById(R.id.editText_lyrics);
        editTextId = (EditText)findViewById(R.id.editText_id);
        btnDodaj = (Button)findViewById(R.id.button_add);
        btnWyswietl = (Button)findViewById(R.id.button_view);
        btnAktualizuj = (Button)findViewById(R.id.button_update);
        btnUsun = (Button)findViewById(R.id.button_delete);
        Dodaj();
        Wyswietl();
        Aktualizuj();
        Usun();
    }

    public void Dodaj() {
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editTitle.getText().toString(), editPlace.getText().toString(), editPage.getText().toString(),
                        editNr.getText().toString(), editLyrics.getText().toString());
                if(isInserted == true) Toast.makeText(MainActivity.this, "Piosenka została dodana.", Toast.LENGTH_LONG).show();
                else Toast.makeText(MainActivity.this, "Piosenka nie została dodana.", Toast.LENGTH_LONG).show();
            }
        });
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Aktualizuj() {
        btnAktualizuj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDB.updateData(editTextId.getText().toString(), editTitle.getText().toString(),
                                editPlace.getText().toString(), editPage.getText().toString(), editNr.getText().toString(),
                                editLyrics.getText().toString());
                        if(isUpdated == true) {
                            Toast.makeText(MainActivity.this, "Zaktualizowano.", Toast.LENGTH_LONG).show();
                        }
                        else Toast.makeText(MainActivity.this, "Nie udało się zaktualizować.", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

    public void Usun() {
        btnUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDB.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0) Toast.makeText(MainActivity.this, "Piosenka została usunięta.", Toast.LENGTH_LONG).show();
                        else Toast.makeText(MainActivity.this, "Piosenka nie została usunięta.", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
