package com.example.ewelina.spisek;

import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private android.support.v4.app.FragmentManager fragmentManager;

    DatabaseHelper myDB;
    EditText editTitle, editPlace, editPage, editNr, editLyrics;
    Button btnDodaj;
    Button btnWyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.navigation);
        fragmentManager = getSupportFragmentManager();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.action_add:
                        fragment = new AddFragment();
                        break;
                    case R.id.action_info:
                        fragment = new InfoFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#999999"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        myDB = new DatabaseHelper(this);

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
}
