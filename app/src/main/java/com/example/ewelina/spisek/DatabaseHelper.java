package com.example.ewelina.spisek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ewelina on 2017-07-14.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "spisek.db";
    public static final String TABLE_NAME = "song_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "PLACE";
    public static final String COL_4 = "PAGE";
    public static final String COL_5 = "NR";
    public static final String COL_6 = "LYRICS";
    public static final String COL_7 = "CHORDS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, PLACE TEXT, PAGE INTEGER, NR INTEGER, LYRICS TEXT, CHORDS TEXT );");

        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('A moc wychodziła z Niego', 'Białostocki', '5', '', 'A moc wychodziła z Niego i uzdrawiała wszystkich', 'cisEH/AHcis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('A-a-a-alleluja', 'Białostocki', '5', '', 'i ho-ho-ho-hosanna', 'CFG/CF/GC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Albowiem tak Bóg', 'Białostocki', '5', '', 'Syna jednorodzonego dał, życie wieczne miał', 'dC/dCd/dC/dCd/CFg/dA7');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja alleluja alleluja', 'Białostocki', '5', '', 'Panem jest wszechmogący Bóg', 'aeGa//ae/aG/FGa');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja alleluja alleluja alleluja', 'Białostocki', '5', '', 'Niech zabrzmi Panu chwała w niebiosach', 'eDCHe//eDe/GDe/CDe/eheCH');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja alleluja amen amen', 'Białostocki', '6', '', 'On naszym Panem jest', 'aGea//G/a/G/a/G/a/Gea');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja chwalcie Pana u świątyni bram', 'Białostocki', '6', '', 'Wszystko, co żyje', 'DGDA/DEGA,DGDA/DEGA//GAh/AGAh');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja Glory alleluja', 'Białostocki', '7', '', 'Chwalmy Go', 'DhGA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja wznieś pod niebo głos', 'Białostocki', '7', '', 'Pan dał chleba moc', 'GD/DCaG//CD/GH7e/CDGG7/CD/GH7e/aDG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ani mój brat ani siostra', 'Białostocki', '7', '', '', 'DfisAh/eAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bądź Królową moich czystych myśli', 'Białostocki', '8', '', 'Matko łaski pełna', 'eahe(ah)/CDe(H7)//x2 GF/ae/CD/CH7/ea(C)h//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bądź pozdrowiona', 'Białostocki', '8', '', 'Panienko pełna Bożej łaski, Ave Maryja', 'DeGD/x2 DfisGA/x2 // DhgD/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bądź z nami w kontakcie', 'Białostocki', '9', '', '', 'DGAD/GAD/GAfish/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bądźże pozdrowiona', 'Białostocki', '9', '', '', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę Ci Panie śpiewał dziś psalm', 'Białostocki', '9', '', '', 'DfisDh/GDeA/GADh/eAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę śpiewał Tobie, mocy moja', 'Białostocki', '9', '', '', 'DGAGh/GADh/DeAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będziemy tańczyć  będziemy śpiewać', 'Białostocki', '10', '', '', 'dBCd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będziesz miłował Pana Boga swego', 'Białostocki', '10', '', '', 'CdC/Cada/aEFaD/GCFGdC//Ca/da/Ce');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Biali czarni i mulaci', 'Białostocki', '10', '', '', 'ADAE/x4 // fiscis/AE coda:ADAE/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Blisko blisko', 'Białostocki', '11', '', '', 'dB/gAd/dB/gA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosław duszo moja Pana', 'Białostocki', '11', '', '', 'Ecis/DAH//x2 Afis/E/Afis/E/Afis/EAE/Afis/Hgis/Afis/H coda:E/cis/D/AH');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławiona Dziewico', 'Białostocki', '12', '', '', 'GC/aD/heaD/GD/GCG//GDG/GCG/GCDG/A7D7');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławione jest Imię Twe', 'Białostocki', '12', '', '', 'GhCD/CDGe/aD//GhCD/x3 GhC/DG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławione serca', 'Białostocki', '13', '', '', 'CeFC/adFG/CGeF/dCaFG//CGaG/FCFG/CGFGC/FCGFGC(G)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławiony bądź Ojcze', 'Białostocki', '13', '', '', 'CFC/CFG/FGea/FGC/FGea/FG(G7)//x2 //G7C/FG7/G7C/F/CFC/FGC/FGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bo góry mogą ustąpić', 'Białostocki', '14', '', '', 'AD/x2 AD/x2 h/D/hD/EADA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bo jak śmierć potężna jest miłość', 'Białostocki', '15', '', '', 'CFC/dGC/CFCFGC/FG/CGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boża radość jak rzeka', 'Białostocki', '15', '', '', 'D/GD/DGA/D/GD/GAD//D/G/A/D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boże obdarz Kościół Twój', 'Białostocki', '15', '', '', 'DfisGA/heFis//hA/efis/hA/efis(A)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boże Twa łaska', 'Białostocki', '15', '', '', 'EHA/x2 fisAH/fisAEH//E/AH//x2 /// DAG/x2 eGA/eGDA//D/GA//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boże w dobroci nigdy nieprzebrany', 'Białostocki', '16', '', '', 'hAhDAh/x2 hAGAhA/AGh//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg i tylko On', 'Białostocki', '17', '', '', 'Dh/x2 GADh/GAD(D7)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg jest miłością', 'Białostocki', '17', '', '', 'GCG/heaD/GCGDCDG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg jest zawsze między nami', 'Białostocki', '17', '', 'Emmanuel', 'aF/CG//x3 aF/CGE// aFCG//x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg kiedyś stał się jednym z nas', 'Białostocki', '17', '', '', 'CGC/CFG//Fd/GC/FGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg kocha mnie', 'Białostocki', '18', '', '', 'DhGA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg nad swym ludem zmiłował się', 'Białostocki', '18', '', 'Chryste króluj, Chryste zwyciężaj', 'eaH7e/aGH7/eaH7e/CaGDD7//G/aGe/aD7G(H7)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg nie umarł Jezus żyje', 'Białostocki', '18', '', '', 'D/A/D/A/A/DAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg tak umiłował świat', 'Białostocki', '19', '', '', 'GC/DG//x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Byłaś przy mnie kiedy zmoczył mnie deszcz', 'Białostocki', '19', '', '', 'CdG/CdG/GC//x2 FG/CF//x2 GC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cała ziemio śpiewaj Mu Królowi chwał', 'Białostocki', '19', '', 'Bo nasz Pan najwyższej godzien jest chwały', 'EAEAEHE/Hcis/Hcis/DHE/DH');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cała ziemio wołaj z radości na cześć Pana', 'Białostocki', '20', '', '', 'aDGa/eCeCa/CDehGDa//x2 a/CDe/CDe//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Checemy Cię uwielbiać', 'Białostocki', '20', '', ' A gu gu', 'aCG/x4 //FGA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcemy słuchać Cię', 'Białostocki', '21', '', 'Twoje słowo jak lampa dla stóp', 'FGC/FGe/FG/de/FGA//x2 ae/FG/de/FGDd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę przestąpić Jego próg', 'Białostocki', '21', '', 'Pan radością mą', 'DG/fish/DGA7/DG/fish/GA7D// DG/fish/GAD//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę tylko byś był nic więcej', 'Białostocki', '22', '', 'Wystarczy byś był', '(D)GD/GD/Gfish(A)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę wielbić Cię Tyś moim Bogiem jest', 'Białostocki', '22', '', 'O Jezu, każdego dnia', 'GDe/CaGD/GDe/Ca/GD// GD/Ca/GD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę wywyższać Imię Twe', 'Białostocki', '22', '', '', 'GCD/x4 //GCdCG/x3 /DG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chciałem w swoim kraju tak normalnie żyć', 'Białostocki', '23', '', 'Tak jak tysiące gwiazd, Ojcze Abrahamie', 'DG/DA//x4 (A7) // DA/eG//x4 (D)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chciałem życiem Ci wyśpiewać pieśń', 'Białostocki', '23', '', 'A Ty mnie nie przestałeś kochać', 'Cea/FedG/ea/ea/FedG// Cea/FedG/FGCa/FGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chleb Niebiański dał nam Pan', 'Białostocki', '24', '', '', 'eACDe/CDCe// eAD/eD/aC/a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chlebie najcichszy', 'Białostocki', '25', '', '', 'GD/CD/GD/ae// eCGD/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chlebie żywy', 'Białostocki', '25', '', '', 'hAGFis/GAh(Fis) // hAG/GAh');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Choć mam wiele pytań', 'Białostocki', '25', '', 'Wiara czyni cuda', 'aGFGC/x3 AGFGE/E// aGFG/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Choćby góry ustąpiły', 'Białostocki', '26', '', '', '(G)DCDC/G/GDCDC/GDCG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chodź ze mną kiedy', 'Białostocki', '26', '', 'Ratuj mnie', 'GeD/x8 //eG/eG/eGa(C)//x2 ');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chrystus cierpiał za nas', 'Białostocki', '27', '', '', 'ADAE/DEAcis/DEfishDA// A/DEfis/h7A/DEfis/hfish/ADEA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chrystus Pan karmi nas', 'Białostocki', '27', '', '', 'eH7/eH7/eae(H7)// Cae/CDe//x2 (H7)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chrystus Pan Boży Syn', 'Białostocki', '28', '', '', 'Ga/GCa/GaG/CAGD// CDGe/CDGD/CDGe/CD/G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chrystus Chrystus to nadzieja cała nasza', 'Białostocki', '28', '', '', 'CFC/dGDD7G/CGC/adGC/aCe/FdGC// CaC/dea/dGa/GdaCFd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalcie Pana narody', 'Białostocki', '29', '', 'Wysławiajce Go ludy', 'fishEA/DGCis// fis/D/E/Cis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalcie Pana niebios', 'Białostocki', '30', '', 'Chwalcie Go na cytrze', 'fis/EDfis// fis/EDfis/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalę Ciebie Panie i uwielbiam', 'Białostocki', '30', '', 'Bo wielkiś Ty', 'Ce/FG/FG// Ca/FG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalę Cię mój Boże chwalę', 'Białostocki', '30', '', 'Chwalmy Pana w rytmie reggae', 'eah');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalę Cię Panie całym moim sercem', 'Białostocki', '31', '', 'O Najwyższy', 'hGDA/x4 FisGA// hGDA/x3');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ci co zaufali Panu', 'Białostocki', '31', '', '', 'Dh/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ci którzy Jahwe ufają', 'Białostocki', '31', '', '', 'EHAH');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ciągle zaczynam od nowa', 'Białostocki', '31', '', '', 'CGC/dGC//x2 aFa/eG//x2 dGC/x2');");

        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cichy zapada zmrok', 'Białostocki', '32', '', '', 'aGC/FC/aGC/Fa/CFdGCE/ada');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ciebie całą duszą pragnę', 'Białostocki', '32', '', 'Boże, jesteś moim Bogiem', 'agad/FC/FBCd/ad// dCd/BF/dCF/dA7d');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cieszę się Jezus zbawił mnie', 'Białostocki', '33', '', '', 'EH7/H7/E/EAH7// cisAH7E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cieszę się alleluja', 'Białostocki', '33', '', '', 'D/GA(D)//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Co za radość usłyszeć dziś', 'Białostocki', '33', '', '', 'Ecis/AEH7/Ecis/AH7/E// cisfis/AH7/cisfis/AH7');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Com przyrzekł Bogu', 'Białostocki', '33', '', '', 'CGC/CFGC//x2 CFGC/x3');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Cóż Ci Jezu damy', 'Białostocki', '34', '', '', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Czcijmy Jezusa czcijmy Go', 'Białostocki', '34', '', '', 'DGD/GA/DGD// Dh/x3 G/AD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Czego chcesz od nas Panie', 'Białostocki', '34', '', '', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dla mnie bowiem żyć to Chrystus', 'Białostocki', '35', '', '', 'Dfish/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Do Ciebie Panie woła dusza moja', 'Białostocki', '35', '', 'Jezu, pragnę blisko Ciebie być', 'GC9G/C9G/C9G/C9G// eCGD/x3 eCG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dotknął mnie dziś mój Pan', 'Białostocki', '35', '', '', 'CFC/FCGC//x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dotknij ogniem moją rękę', 'Białostocki', '36', '', '', 'EA/x3 E// H/A/H// EAE/x3');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dotknij Panie moich oczu', 'Białostocki', '36', '', '', 'DAhGA/x2 DAheCA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duch Pański nade mną', 'Białostocki', '36', '', '', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duch Pański napełnił okrąg ziemi', 'Białostocki', '36', '', '', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Chrystusowy', 'Białostocki', '38', '', 'Idźmy i głośmy', 'dCFBgFCd/dCFBgFCF/aGaGa/FGaFG(a)//x2 (A) DAGD/hGA/GDAhGhA/hGA/GAA7/hfis/GD/hG/eA7/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu miłości wylewaj się na nas', 'Białostocki', '39', '', '', 'DAhD/GDGA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Ogniu Duchu Żarze', 'Białostocki', '39', '', '', 'eh/CD/GC/aCH7// GH7e/acH7/Gea/H7e(a)H7');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź i rozpal nas', 'Białostocki', '39', '', '', 'aF/dE/aF/dE(a)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź ze Swym ogniem', 'Białostocki', '39', '', '', 'a/da/FGa/FGE// FGa/x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty powiej wiatrem', 'Białostocki', '40', '', '', 'Dh/eA//x2 Dh/eA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź niech wiara zagości', 'Białostocki', '40', '', '', 'DAD/DGA/GDGD/GDA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty Tchnienie Ojca', 'Białostocki', '40', '', 'Tak pragniemy Ciebei Panie', 'GCG/x2 eh/CG/CG/D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty wołam przyjdź', 'Białostocki', '40', '', 'Wszechmogący Bóg jest pośród nas', 'C/g/F/C// gFC/x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzielmy się wiarą jak chlebem', 'Białostocki', '41', '', '', 'DA/GeA//x2 hfis/GeA//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki Ci Maryjo Maryjo dzięki Ci', 'Białostocki', '41', '', '', 'EH7AE/FisAE// giscis/gisA/FiisH7/giscis/gisA/FisAE');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki Ci Panie za Ciało Twe i Krew', 'Białostocki', '42', '', '', 'cgAsEs/BcFfG//x2 (c) cBEs/AscB/EsAsc/FG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki za Twój krzyż', 'Białostocki', '43', '', '', 'DAh/GDA/DAh/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki Panie za Twą łaskę', 'Białostocki', '43', '', '', 'Dh/GA/Fish/GAD// Dh/GA/Fish/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dziękujcie Pan Bogu bo jest dobry', 'Białostocki', '43', '', 'Dziękujcie Panu Bogu bo łaska Jego trwa', 'fisEAE/AEDfis// fisAEfis/fisAEA/DEAfis/AEfis/Efis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dziś jest czas by oddać Bogu chwałę', 'Białostocki', '44', '', '', 'DGD/DGA/GDGD/GCA// DGAD/x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy Boży Duch wypełnia mnie', 'Białostocki', '44', '', '', 'e/He// aeHe');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy drogi pomyli los zły', 'Białostocki', '44', '', '', 'GC/De/CDG(CD)/GC/De/CDG(G7)// CD/Ghe/CD/G(G7)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy kiedyś Pan powróci znów', 'Białostocki', '45', '', '', 'D/DA7/DD7Gg/DAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy klęczę przed Tobą', 'Białostocki', '45', '', 'Ave Maria gratia plena', 'GhCD/GhCD/GCDG/CDG// GhCD/GhCD/GCDG/CDG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy po wielkim połowie', 'Białostocki', '45', '', '', 'Ge/aD//x5');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy schodzimy się niech święty Duch w nas działa', 'Białostocki', '46', '', '', 'DfisGA/DfisGA/GADh/GADD7/GADD7/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy uczniów Swych posyłał Pan', 'Białostocki', '46', '', 'Sandały', 'eD/ae//x2 CDG/DG/CDG/De');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy wokoło wielka burza', 'Białostocki', '46', '', 'Gdy na morzu wielka burza', 'DG/AD//x4');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy wpatruję się w Twą świętą twarz', 'Białostocki', '47', '', '', 'CeFf/x3 G //x2 FG/Cea/dGC7/FGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdyby wiara twa', 'Białostocki', '47', '', 'Gorczycy ziarno, gorczycy ziarnko', 'aE/Ea/da/Ea/Ea/Ea aEa');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdzie miłość wzajemna i dobroć', 'Białostocki', '47', '', '', 'Gahe/aCD7G// GCG/GCD/GCG/GCD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Głoś Imię Pana', 'Białostocki', '48', '', '', 'Dh/fiseAD//x2 DGDGe/ADAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gloria in excelsis Deo', 'Białostocki', '48', '', '', 'AcisDE ... DEDE /x2 (Amen) AcisDE/EA');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Godzien chwały jest Baranek', 'Białostocki', '49', '', '', 'Da7/CG albo: Ae7/GD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Godzien jesteś, godzien jesteś Panie i Boże nasz ', 'Białostocki', '50', '', '', 'GC/GD7/GC/GD7G/DG/DG/G7C/GD7G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Godzien jesteś wielki Boże', 'Białostocki', '50', '', '', 'Ca/FG/Ca/FGC// FGa/FGa(C)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Godzien o godzien nasz Bóg', 'Białostocki', '51', '', 'Godzien o godzien jest Bóg', 'GDe/CGCD/GDe/CGCG//FCD(CDD7)// GDCD/x3 G(D)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Golgoto', 'Białostocki', '51', '', 'W tej ciszy przebywam, To nie gwoździe Cię przybiły', 'adGCE aE/FC/da/E// a/d/G/CE/a/d/aE/a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gwiazdo Zaranna', 'Białostocki', '52', '', 'Litania', 'EAEfis/H7E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Hej Jezu Królem Tyś', 'Białostocki', '53', '', '', 'GCG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Hosanna na niebiosach', 'Białostocki', '53', '', '', 'G/D/eCD// CDGe/x3 CDG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('I to jest właśnie to', 'Białostocki', '53', '', '', 'GC/DGCD/Ga/DG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Idzie mój Pan', 'Białostocki', '53', '', '', 'e/aH7e// eae/DH7e//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Idzie nasza karawana', 'Białostocki', '54', '', '', 'Dh/GA/Dh/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Idziemy razem trzymamy się za ręce', 'Białostocki', '54', '', '', 'DGD/eA//x2 D/A/ADGA/D/G/GDA/D(D7)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Idźcie na cały świat', 'Białostocki', '54', '', '', 'ehe/eaeD// GDG/DCD/GDG/DCD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Imię Pana chwalmy dziś', 'Białostocki', '55', '', '', 'D/GA/DGA/DGSG/GAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja widzę Króla chwały', 'Białostocki', '55', '', 'Hosanna', 'E/cis/fisH//x2 EAHcis/AcisH/AHcis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja wiem On ocalił mnie', 'Białostocki', '56', '', '', 'EA/x8 (podnoszę dłonie) H/AH// EAEH');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja wiem że jesteś Panie mój', 'Białostocki', '56', '', '', 'CdeF/CGCF/CGCE/aGCd/aGCE/aGCF/CdeF/CGCF');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja wierzę że to Jezus', 'Białostocki', '56', '', '', 'EAH/x4 AHEE7A/HEE7/AHEE7A/HE');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak cię zrozumieć tajemnico', 'Białostocki', '57', '', '', 'cg/fg/cg/fg// C/f/G/c/f/gG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('jak Dawid kiedy przed Bogiem byłł', 'Białostocki', '57', '', '', 'ae/ae/Ga//x2 FG/Fa//x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak dobrze jest dziękować Ci Panie', 'Białostocki', '58', '', '', 'ad/GCE/ad/a/EF/daE');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak król Dawid bądź', 'Białostocki', '58', '', '', 'cFcF');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak łania pragnie wody ze strumieni', 'Białostocki', '58', '', '', 'CeaC/dGCG/CeaC/FGC/FdC/CeaC/FGC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak mi dobrze że jesteś tu Panie', 'Białostocki', '59', '', '', 'GeCD// Ge/CD/GeCD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak niebo nad umierającym słońcem', 'Białostocki', '59', '', '', 'dCF/x3 A/A7// FC/FAd/FC/dAd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak odnaleźć mam Chrystusa', 'Białostocki', '59', '', '', 'De/AD/he/AD// DeAD/DeAD');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak ożywczy deszcz', 'Białostocki', '60', '', '', 'FBdC/x2 gaBa/x2 albo: GCeD/x2 ahCh/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak piękne jest mieszkanie Twe', 'Białostocki', '60', '', 'Lepszy jeden dzień w przedsionkach Twych', 'EcisA/AH/EcisH/EcisAH/EcisH// A/H/A/H coda: cisH/AH/cisHAH/x2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jakże pójdziemy za Tobą Chrystusie', 'Białostocki', '60', '', '', 'eaeD7/eaDH7/DaeD7/eaH7e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak przedziwna Panie miłość Twa', 'Białostocki', '61', '', '', 'Cd/FC/Cd/FC// Ga/Ga/F/C/dF/gC');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jam jest Chleb Życia', 'Białostocki', '61', '', '', 'Gh/CDD7/GhC/GC/aDD7// GDGG7/CGD/GCGDG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jasnej Góry Ty jesteś królową', 'Białostocki', '62', '', '', 'E/fis/H7/EH7/E/fis/H7/EE7// E7A/E/fis/H7E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jeden chleb', 'Białostocki', '62', '', '', 'GC/DG/x2 GC/GD/GC/DG');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jeden jest tylko Pan', 'Białostocki', '63', '', '', 'dgCd/dC/Ad(C)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jedno morze nie objęte wkrąg', 'Białostocki', '63', '', '', 'gd/gF/gF/dEs// gB/Escd/BFg/EsFg');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jedyny Pan prawdziwy Bóg', 'Białostocki', '64', '', '', 'aDGC/x2 FG/aDGC');");

        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Czuję Ciebie jak przepływasz', 'Przymierzowy', '', '1', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Do Ciebie Panie', 'Przymierzowy', '', '2', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dotknij Panie moich oczu', 'Przymierzowy', '', '3', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duch Pański napełnił okrąg ziemi', 'Przymierzowy', '', '4', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu miłości', 'Przymierzowy', '', '5', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Ogniu', 'Przymierzowy', '', '6', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź i rozpal nas', 'Przymierzowy', '', '7', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź niech wiara zagości', 'Przymierzowy', '', '8', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty miłości prawdziwa', 'Przymierzowy', '', '9', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty ogarnij mnie', 'Przymierzowy', '', '10', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty powiej wiatrem', 'Przymierzowy', '', '11', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź i dotknij mnie', 'Przymierzowy', '', '12', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź dotknij mnie', 'Przymierzowy', '', '13', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź działaj', 'Przymierzowy', '', '14', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty przyjdź ze Swym ogniem', 'Przymierzowy', '', '15', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty Tchnienie Ojca', 'Przymierzowy', '', '16', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty wołam przyjdź', 'Przymierzowy', '', '17', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu żyjącego Boga', 'Przymierzowy', '', '18', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Gdy schodzimy się', 'Przymierzowy', '', '19', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak ożywczy deszcz', 'Przymierzowy', '', '20', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezu skało żywa', 'Przymierzowy', '', '21', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezu wejdź do mego serca', 'Przymierzowy', '', '22', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezu tchnij w moje serce', 'Przymierzowy', '', '23', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezus jest pośród nas', 'Przymierzowy', '', '24', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Mów do mnie Panie', 'Przymierzowy', '', '25', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niechaj zstąpi Duch Twój', 'Przymierzowy', '', '26', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niech nas ogarnie', 'Przymierzowy', '', '27', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niech Twój Święty Duch', 'Przymierzowy', '', '28', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niech zapłonie płomień', 'Przymierzowy', '', '29', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Obdarz nas Panie pokojem', 'Przymierzowy', '', '30', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Oczyść serce me', 'Przymierzowy', '', '31', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O Duchu Boży', 'Przymierzowy', '', '32', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O pozwól Zbawcy', 'Przymierzowy', '', '33', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O Stworzycielu Duchu', 'Przymierzowy', '', '34', 'Hymn do Ducha Świętego', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Otwórzcie serca', 'Przymierzowy', '', '35', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Otwórz me oczy chcę widzieć Jezusa', 'Przymierzowy', '', '36', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Otwórz me oczy o Panie', 'Przymierzowy', '', '37', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie mój przygarnij mnie', 'Przymierzowy', '', '38', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie ogień pal', 'Przymierzowy', '', '39', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie przyjdź cały jestem oczekiwaniem', 'Przymierzowy', '', '40', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie światło miłości Twej świeci', 'Przymierzowy', '', '41', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie uzdrów nasz kraj', 'Przymierzowy', '', '42', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przemień serce me', 'Przymierzowy', '', '43', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przybądź Duchu Święty', 'Przymierzowy', '', '44', 'Sekwencja do Ducha Świętego', 'brak');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź dotknij mnie', 'Przymierzowy', '', '45', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Duchu Święty ja pragnę', 'Przymierzowy', '', '46', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Duchu Święty napełnij serca', 'Przymierzowy', '', '47', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Duchu Święty napełnij me serce miłością', 'Przymierzowy', '', '48', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Duchu Święty przypomnij wszystko', 'Przymierzowy', '', '49', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Duchu Święty słysz wołanie', 'Przymierzowy', '', '50', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź i zajmij miejsce Swe', 'Przymierzowy', '', '51', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź jak deszcz', 'Przymierzowy', '', '52', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź przyjdż o Duchu przyjdź', 'Przymierzowy', '', '53', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ruah', 'Przymierzowy', '', '54', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Spocznij na nas Duchu Pana', 'Przymierzowy', '', '55', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Stoisz u naszych drzwi', 'Przymierzowy', '', '56', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Swojego Ducha Panie wylej', 'Przymierzowy', '', '57', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Tchnij moc tchnij miłość', 'Przymierzowy', '', '58', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('W lekkim powiewie', 'Przymierzowy', '', '59', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Wzywam Cię przyjdź umocnij mnie', 'Przymierzowy', '', '60', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Wzywam Cię Duchu przyjdź', 'Przymierzowy', '', '61', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ześlij deszcz', 'Przymierzowy', '', '62', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja alleluja amen', 'Przymierzowy', '', '63', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja alleluja niech zabrzmi Panu chwała', 'Przymierzowy', '', '64', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja zakrólował wszechmocny nasz Bóg', 'Przymierzowy', '', '65', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja chwalcie Pana', 'Przymierzowy', '', '66', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja glory alleluja', 'Przymierzowy', '', '67', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja miłość Twa', 'Przymierzowy', '', '68', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Aż sponad mórz', 'Przymierzowy', '', '69', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bądź pochwalony', 'Przymierzowy', '', '70', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę chwalił Ciebie Panie', 'Przymierzowy', '', '71', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę chwalił Pana na wieki', 'Przymierzowy', '', '72', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę śpiewał Ci', 'Przymierzowy', '', '73', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będę śpiewał Tobie', 'Przymierzowy', '', '74', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Będziemy tańczyć', 'Przymierzowy', '', '75', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Blisko blisko', 'Przymierzowy', '', '76', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławcie Panu', 'Przymierzowy', '', '77', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosław Duszo moja Pana', 'Przymierzowy', '', '78', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosław Pana ma duszo', 'Przymierzowy', '', '79', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławię Cię', 'Przymierzowy', '', '80', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Błogosławione jest Imię Twe', 'Przymierzowy', '', '81', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bo góry mogą ustąpić', 'Przymierzowy', '', '82', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bogu Jedynemu', 'Przymierzowy', '', '83', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boża obecność', 'Przymierzowy', '', '84', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boże Twa łaska', 'Przymierzowy', '', '85', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Boże Tyś wiernym jest', 'Przymierzowy', '', '86', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg i tylko On', 'Przymierzowy', '', '87', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg jest zawsze między nami', 'Przymierzowy', '', '88', 'Emmanuel', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bóg wyprowadza z niewoli', 'Przymierzowy', '', '89', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę przestąpić Jego próg', 'Przymierzowy', '', '90', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę tylko byś był', 'Przymierzowy', '', '91', 'Wystarczy byś był', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę uwielbiać Twoje Imię', 'Przymierzowy', '', '92', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę wielbić Cię', 'Przymierzowy', '', '93', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę w Tobie żyć', 'Przymierzowy', '', '94', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chcę wywyższać Imię Twe', 'Przymierzowy', '', '95', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chociaż góry ustąpią', 'Przymierzowy', '', '96', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Choćby góry ustąpiły', 'Przymierzowy', '', '97', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chrystus Pan', 'Przymierzowy', '', '98', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalcie Pana niebios', 'Przymierzowy', '', '99', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwalcie Pana wszystkie narody', 'Przymierzowy', '', '100', '', '');");











    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String title, String place, String page, String nr, String lyrics, String chords ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, place);
        contentValues.put(COL_4, page);
        contentValues.put(COL_5, nr);
        contentValues.put(COL_6, lyrics);
        contentValues.put(COL_7, chords);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) return false;
        else return true;
    }

    public Cursor viewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String title, String place, String page, String nr, String lyrics, String chords) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, place);
        contentValues.put(COL_4, page);
        contentValues.put(COL_5, nr);
        contentValues.put(COL_6, lyrics);
        contentValues.put(COL_7, chords);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }
}
