package com.example.ewelina.spisek;

import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
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

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private android.support.v4.app.FragmentManager fragmentManager;

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_container, new SearchFragment());
        tx.commit();

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
        myDB.insertData("A moc wychodziła z Niego", "Białostocki", "5", "", "A moc wychodziła z Niego i uzdrawiała wszystkich", "cisEH/AHcis");
        myDB.insertData("A-a-a-alleluja", "Białostocki", "5", "", "i ho-ho-ho-hosanna", "CFG/CF/GC");
        myDB.insertData("Albowiem tak Bóg", "Białostocki", "5", "", "Syna jednorodzonego dał, życie wieczne miał", "dC/dCd/dC/dCd/CFg/dA7");
        myDB.insertData("Alleluja, alleluja, alleluja", "Białostocki", "5", "", "Panem jest wszechmogący Bóg", "aeGa//ae/aG/FGa");
        myDB.insertData("Alleluja, alleluja, alleluja, alleluja", "Białostocki", "5", "", "Niech zabrzmi Panu chwała w niebiosach", "eDCHe//eDe/GDe/CDe/eheCH");
        myDB.insertData("Alleluja, alleluja, amen, amen", "Białostocki", "6", "", "On naszym Panem jest", "aGea//G/a/G/a/G/a/Gea");
        myDB.insertData("Alleluja, chwalcie Pana u świątyni bram", "Białostocki", "6", "", "Wszystko, co żyje", "DGDA/DEGA,DGDA/DEGA//GAh/AGAh");
        myDB.insertData("Alleluja, Glory, alleluja", "Białostocki", "7", "", "Chwalmy Go", "DhGA");
        myDB.insertData("Alleluja, wznieś pod niebo głos", "Białostocki", "7", "", "Pan dał chleba moc", "GD/DCaG//CD/GH7e/CDGG7/CD/GH7e/aDG");
        myDB.insertData("Ani mój brat, ani siostra", "Białostocki", "7", "", "", "DfisAh/eAD");
        myDB.insertData("Bądź Królową moich czystych myśli", "Białostocki", "8", "", "Matko łaski pełna", "eahe(ah)/CDe(H7)//x2 GF/ae/CD/CH7/ea(C)h//x2");
        myDB.insertData("Bądź pozdrowiona", "Białostocki", "8", "", "Panienko pełna Bożej łaski, Ave Maryja", "DeGD/x2 DfisGA/x2 // DhgD/x2");
        myDB.insertData("Bądź z nami w kontakcie", "Białostocki", "9", "", "", "DGAD/GAD/GAfish/GAD");
        myDB.insertData("Bądźże pozdrowiona", "Białostocki", "9", "", "", "brak");
        myDB.insertData("Będę Ci, Panie, śpiewał dziś psalm", "Białostocki", "9", "", "", "DfisDh/GDeA/GADh/eAD");
        myDB.insertData("Będę śpiewał Tobie, mocy moja", "Białostocki", "9", "", "", "DGAGh/GADh/DeAD");
        myDB.insertData("Będziemy tańczyć,  będziemy śpiewać", "Białostocki", "10", "", "", "dBCd");
        myDB.insertData("Będziesz miłował Pana Boga swego", "Białostocki", "10", "", "", "CdC/Cada/aEFaD/GCFGdC//Ca/da/Ce");
        myDB.insertData("Biali, czarni i mulaci", "Białostocki", "10", "", "", "ADAE/x4 // fiscis/AE coda:ADAE/x2");
        myDB.insertData("Blisko, blisko", "Białostocki", "11", "", "", "dB/gAd/dB/gA");
        myDB.insertData("Błogosław duszo moja Pana", "Białostocki", "11", "", "", "Ecis/DAH//x2 Afis/E/Afis/E/Afis/EAE/Afis/Hgis/Afis/H coda:E/cis/D/AH");
        myDB.insertData("Błogosławiona Dziewico", "Białostocki", "12", "", "", "GC/aD/heaD/GD/GCG//GDG/GCG/GCDG/A7D7");
        myDB.insertData("Błogosławione jest Imię Twe", "Białostocki", "12", "", "", "GhCD/CDGe/aD//GhCD/x3 GhC/DG");
        myDB.insertData("Błogosławione serca", "Białostocki", "13", "", "", "CeFC/adFG/CGeF/dCaFG//CGaG/FCFG/CGFGC/FCGFGC(G)");
        myDB.insertData("Błogosławiony bądź Ojcze", "Białostocki", "13", "", "", "CFC/CFG/FGea/FGC/FGea/FG(G7)//x2 //G7C/FG7/G7C/F/CFC/FGC/FGC");
        myDB.insertData("Bo góry mogą ustąpić", "Białostocki", "14", "", "", "AD/x2 AD/x2 h/D/hD/EADA");
        myDB.insertData("Bo jak śmierć potężna jest miłość", "Białostocki", "15", "", "", "CFC/dGC/CFCFGC/FG/CGC");
        myDB.insertData("Boża radość jak rzeka", "Białostocki", "15", "", "", "D/GD/DGA/D/GD/GAD//D/G/A/D");
        myDB.insertData("Boże obdarz Kościół Twój", "Białostocki", "15", "", "", "DfisGA/heFis//hA/efis/hA/efis(A)");
        myDB.insertData("Boże Twa łaska", "Białostocki", "15", "", "", "EHA/x2 fisAH/fisAEH//E/AH//x2 /// DAG/x2 eGA/eGDA//D/GA//x2");
        myDB.insertData("Boże, w dobroci nigdy nieprzebrany", "Białostocki", "16", "", "", "hAhDAh/x2 hAGAhA/AGh//x2");
        myDB.insertData("Bóg i tylko On", "Białostocki", "17", "", "", "Dh/x2 GADh/GAD(D7)");
        myDB.insertData("Bóg jest miłością", "Białostocki", "17", "", "", "GCG/heaD/GCGDCDG");
        myDB.insertData("Bóg jest zawsze między nami", "Białostocki", "17", "", "Emmanuel", "aF/CG//x3 aF/CGE// aFCG//x4");
        myDB.insertData("Bóg kiedyś stał się jednym z nas", "Białostocki", "17", "", "", "CGC/CFG//Fd/GC/FGC");
        myDB.insertData("Bóg kocha mnie", "Białostocki", "18", "", "", "DhGA");
        myDB.insertData("Bóg nad swym ludem zmiłował się", "Białostocki", "18", "", "Chryste króluj, Chryste zwyciężaj", "eaH7e/aGH7/eaH7e/CaGDD7//G/aGe/aD7G(H7)");
        myDB.insertData("Bóg nie umarł, Jezus żyje", "Białostocki", "18", "", "", "D/A/D/A/A/DAD");
        myDB.insertData("Bóg tak umiłował świat", "Białostocki", "19", "", "", "GC/DG//x4");
        myDB.insertData("Byłaś przy mnie, kiedy zmoczył mnie deszcz", "Białostocki", "19", "", "", "CdG/CdG/GC//x2 FG/CF//x2 GC");
        myDB.insertData("Cała ziemio śpiewaj Mu, Królowi chwał", "Białostocki", "19", "", "Bo nasz Pan najwyższej godzien jest chwały", "EAEAEHE/Hcis/Hcis/DHE/DH");
        myDB.insertData("Cała ziemio wołaj z radości na cześć Pana", "Białostocki", "20", "", "", "aDGa/eCeCa/CDehGDa//x2 a/CDe/CDe//x2");
        myDB.insertData("Checemy Cię uwielbiać", "Białostocki", "20", "", " A gu gu", "aCG/x4 //FGA");
        myDB.insertData("Chcemy słuchać Cię", "Białostocki", "21", "", "Twoje słowo jak lampa dla stóp", "FGC/FGe/FG/de/FGA//x2 ae/FG/de/FGDd");
        myDB.insertData("Chcę przestąpić Jego próg", "Białostocki", "21", "", "Pan radością mą", "DG/fish/DGA7/DG/fish/GA7D// DG/fish/GAD//x2");
        myDB.insertData("Chcę tylko byś był, nic więcej", "Białostocki", "22", "", "Wystarczy byś był", "(D)GD/GD/Gfish(A)");
        myDB.insertData("Chcę wielbić Cię, Tyś moim Bogiem jest", "Białostocki", "22", "", "O Jezu, każdego dnia", "GDe/CaGD/GDe/Ca/GD// GD/Ca/GD");
        myDB.insertData("Chcę wywyższać Imię Twe", "Białostocki", "22", "", "", "GCD/x4 //GCdCG/x3 /DG");
        myDB.insertData("Chciałem w swoim kraju tak normalnie żyć", "Białostocki", "23", "", "Tak jak tysiące gwiazd, Ojcze Abrahamie", "DG/DA//x4 (A7) // DA/eG//x4 (D)");
        myDB.insertData("Chciałem życiem Ci wyśpiewać pieśń", "Białostocki", "23", "", "A Ty mnie nie przestałeś kochać", "Cea/FedG/ea/ea/FedG// Cea/FedG/FGCa/FGC");
        myDB.insertData("Chleb Niebiański dał nam Pan", "Białostocki", "24", "", "", "eACDe/CDCe// eAD/eD/aC/a");
        myDB.insertData("Chlebie najcichszy", "Białostocki", "25", "", "", "GD/CD/GD/ae// eCGD/x2");
        myDB.insertData("Chlebie żywy", "Białostocki", "25", "", "", "hAGFis/GAh(Fis) // hAG/GAh");

    }
}
