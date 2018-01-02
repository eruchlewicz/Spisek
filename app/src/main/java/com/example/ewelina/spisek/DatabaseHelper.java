package com.example.ewelina.spisek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    public static final String TABLE_NAME2 = "songbook_table";
    public static final String COL_8 = "ID";
    public static final String COL_9 = "TITLE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, PLACE TEXT, PAGE INTEGER, NR INTEGER, LYRICS TEXT, CHORDS TEXT );");
        db.execSQL("create table " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT);");

        db.execSQL("INSERT INTO " + TABLE_NAME2 + "(TITLE) VALUES ('Przymierzowy');");
        db.execSQL("INSERT INTO " + TABLE_NAME2 + "(TITLE) VALUES ('Pomarańczowy segregator');");

// pomaranczowy

        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Stoję dziś', 'Pomarańczowy segregator', '', '1', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zbudź się duszo moja', 'Pomarańczowy segregator', '', '2', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zakochaj się w Panu', 'Pomarańczowy segregator', '', '3', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przed tronem Twym', 'Pomarańczowy segregator', '', '4', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Tak wielki Bóg (Tato)', 'Pomarańczowy segregator', '', '5', '', 'B lub C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Godzien jesteś', 'Pomarańczowy segregator', '', '6', '', 'E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Bogaty w każdy cud', 'Pomarańczowy segregator', '', '7', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jesteś tarczą by chronić mnie', 'Pomarańczowy segregator', '', '8', '', 'E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Uwielbiam Cię najcichsza obecności', 'Pomarańczowy segregator', '', '9', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duszo ma Pana chwal', 'Pomarańczowy segregator', '', '10', '', '(A)G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Mój Pan nieśmiertelny', 'Pomarańczowy segregator', '', '11', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O przyjdź wypełnij mnie', 'Pomarańczowy segregator', '', '12', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nasz Bóg jest wielki (Wodę zamieniłeś w wino)', 'Pomarańczowy segregator', '', '13', '', 'cis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Już nie szukam Panie', 'Pomarańczowy segregator', '', '14', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Kocham Cię mówi Pan', 'Pomarańczowy segregator', '', '15', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nikt Cię nie kocha tak jak ja', 'Pomarańczowy segregator', '', '16', '', 'E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Pasja miłości (On zdradzony jak nikt)', 'Pomarańczowy segregator', '', '17', '', '');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ukojenie', 'Pomarańczowy segregator', '', '18', '', 'Es');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nie bójcie się żyć dla miłości', 'Pomarańczowy segregator', '', '19', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja dziękuję Ci za Twą świętą Krew', 'Pomarańczowy segregator', '', '20', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Wciąż mnie zadziwiasz Panie', 'Pomarańczowy segregator', '', '21', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Uwielbiam Twoje Imię, uwielbiam Twoje serce', 'Pomarańczowy segregator', '', '22', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Maryjo chcę zamieszkać z Tobą', 'Pomarańczowy segregator', '', '23', '', 'F');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak przedziwna Panie miłość Twa', 'Pomarańczowy segregator', '', '24', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Modlitwa franciszkańska', 'Pomarańczowy segregator', '', '25', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jesteśmy chwilą', 'Pomarańczowy segregator', '', '26', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Śpiewajmy Panu Bogu śpiewajmy', 'Pomarańczowy segregator', '', '27', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ty znasz mnie Panie', 'Pomarańczowy segregator', '', '28', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ojcze mój chcę czcić Cię bardziej', 'Pomarańczowy segregator', '', '29', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zostałem stworzony by wielbić Cię', 'Pomarańczowy segregator', '', '30', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niebo dziś otwiera się', 'Pomarańczowy segregator', '', '31', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Krok za krokiem', 'Pomarańczowy segregator', '', '32', '', 'h');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Mówię TAK życiu', 'Pomarańczowy segregator', '', '33', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Z całej duszy (Gdy zbieramy się)', 'Pomarańczowy segregator', '', '34', '', 'a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zrzuć na mnie troski swe', 'Pomarańczowy segregator', '', '35', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Tylko Ty i ja', 'Pomarańczowy segregator', '', '36', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nie mogę zrobić nic', 'Pomarańczowy segregator', '', '37', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nie mam nic (Puste ręce)', 'Pomarańczowy segregator', '', '38', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Wybrałeś mnie (Przy Twym krzyżu)', 'Pomarańczowy segregator', '', '39', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jeżeli to Twój głos mój Boże', 'Pomarańczowy segregator', '', '40', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Panie przemień wino w Krew', 'Pomarańczowy segregator', '', '41', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Pośpieszcie o wierni', 'Pomarańczowy segregator', '', '42', '', 'F');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chwała Tobie Słowo mądrości', 'Pomarańczowy segregator', '', '43', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja wołam Tato', 'Pomarańczowy segregator', '', '44', '', 'F');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jak przedziwna Panie (ref)', 'Pomarańczowy segregator', '', '45', '', 'F');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Mario czy Ty wiesz', 'Pomarańczowy segregator', '', '46', '', 'a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O krwi i wodo', 'Pomarańczowy segregator', '', '47', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nie nam Panie nie nam', 'Pomarańczowy segregator', '', '48', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niech Ci błogosławi Pan', 'Pomarańczowy segregator', '', '49', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O wychwalajcie Go wszystkie narody', 'Pomarańczowy segregator', '', '50', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nie lękajcie się ja jestem z wami', 'Pomarańczowy segregator', '', '51', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Hymn o miłości (Nie dla swej chwały)', 'Pomarańczowy segregator', '', '52', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Pewnej nocy łzy z oczu mych', 'Pomarańczowy segregator', '', '53', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Naucz mnie miłości krzyża', 'Pomarańczowy segregator', '', '54', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Radośnie Panu hymn śpiewajmy', 'Pomarańczowy segregator', '', '55', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Prawdziwie nie ma Go tu', 'Pomarańczowy segregator', '', '56', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezu ufam Tobie', 'Pomarańczowy segregator', '', '57', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Okaż mi Boże miłosierdzie', 'Pomarańczowy segregator', '', '58', '', 'h');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('W Twoich oczach niebo (Poprowadź mnie)', 'Pomarańczowy segregator', '', '59', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Serce w sercu', 'Pomarańczowy segregator', '', '60', '', 'F');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Oczekuję Ciebie Panie', 'Pomarańczowy segregator', '', '61', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Koronka', 'Pomarańczowy segregator', '', '62', '', 'fis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jego miłość', 'Pomarańczowy segregator', '', '63', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Litania (Matko która nas znasz)', 'Pomarańczowy segregator', '', '64', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nowe imię', 'Pomarańczowy segregator', '', '65', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Słuchaj Córko', 'Pomarańczowy segregator', '', '66', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dotknij Panie rany mej (To co raną jest w mym sercu)', 'Pomarańczowy segregator', '', '67', '', 'B');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Litania Loretańska', 'Pomarańczowy segregator', '', '68', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('W Swoim wielkim miłosierdziu', 'Pomarańczowy segregator', '', '69', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezusie Synu Dawida', 'Pomarańczowy segregator', '', '70', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja wołam Panie', 'Pomarańczowy segregator', '', '71', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjdź Panie Jezu dotknij uzdrów mnie', 'Pomarańczowy segregator', '', '72', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jezus Cię kocha', 'Pomarańczowy segregator', '', '73', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty Boże przyjdź', 'Pomarańczowy segregator', '', '74', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ja pragnę więcej Ciebie', 'Pomarańczowy segregator', '', '75', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Alleluja zakrólował wszechmocny nasz Bóg', 'Pomarańczowy segregator', '', '76', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zaufałem Panu i już', 'Pomarańczowy segregator', '', '77', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki Ci Maryjo (To jej piękne oblicze)', 'Pomarańczowy segregator', '', '78', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Niech Cię Pan błogosławi i strzeże', 'Pomarańczowy segregator', '', '79', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nad Jordanem', 'Pomarańczowy segregator', '', '80', '', 'a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Ty dałeś mi nadzieję dziś (Twoja chwała)', 'Pomarańczowy segregator', '', '81', 'Na wieki wieków', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Nawróć się ludu w pokorze', 'Pomarańczowy segregator', '', '82', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Rozpięty na ramionach', 'Pomarańczowy segregator', '', '83', '', 'a');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Twój krzyż jego ramiona mnie oplatają', 'Pomarańczowy segregator', '', '84', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Upadnij na kolana', 'Pomarańczowy segregator', '', '85', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zbawienie przyszło przez krzyż', 'Pomarańczowy segregator', '', '86', '', 'h');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('O Krwi Najdroższa', 'Pomarańczowy segregator', '', '87', '', 'c');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Witam CIę witam', 'Pomarańczowy segregator', '', '88', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Przyjacielu (Bo nie ma większej miłości)', 'Pomarańczowy segregator', '', '89', '', 'G lub D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Żadna pieśń (Nie ukochałem mego krzyża)', 'Pomarańczowy segregator', '', '90', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Goloto', 'Pomarańczowy segregator', '', '91', '', 'g');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Duchu Święty Stworzycielu', 'Pomarańczowy segregator', '', '92', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Żyje Pan nasz Pan Alleluja', 'Pomarańczowy segregator', '', '93', '', 'A');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Oto jest dzień który dał nam Pan', 'Pomarańczowy segregator', '', '94', '', 'C');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Albowiem tak Bóg', 'Pomarańczowy segregator', '', '95', '', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Chlebie żywy', 'Pomarańczowy segregator', '', '96', '', 'h');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Dzięki za Twój krzyż', 'Pomarańczowy segregator', '', '97', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Tak mnie skrusz', 'Pomarańczowy segregator', '', '98', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Pan jest mocą swojego ludu', 'Pomarańczowy segregator', '', '99', '', 'D');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Z Tobą ciemność nie będzie ciemna', 'Pomarańczowy segregator', '', '100', '', 'Fis');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Jeśli masz chwile smutne w swym życiu', 'Pomarańczowy segregator', '', '101', 'Kiedy masz chwile smutne w swym życiu Matce która pod krzyżem stała', 'e');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Moja droga jest prosta', 'Pomarańczowy segregator', '', '102', '', 'E');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Powiedz światu Jezus żyje', 'Pomarańczowy segregator', '', '103', '', 'd');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Śpiewajmy Panu Bogu śpiewajmy', 'Pomarańczowy segregator', '', '104', '', 'G');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(TITLE, PLACE, PAGE, NR, LYRICS, CHORDS) VALUES ('Zmartwychwstał Pan zwycięstwa chwałą niebo brzmi (Baranek Królem jest)', 'Pomarańczowy segregator', '', '105', '', 'G');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
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

    public Integer updateData(Integer id, String title, String place, String page, String nr, String lyrics, String chords) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "ID="+id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, place);
        contentValues.put(COL_4, page);
        contentValues.put(COL_5, nr);
        contentValues.put(COL_6, lyrics);
        contentValues.put(COL_7, chords);
        return db.update(TABLE_NAME, contentValues, where, null);
    }

    public Integer deleteData(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "ID="+id;
        return db.delete(TABLE_NAME, where, null);
    }

    public ArrayList<Song> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Song> product= new ArrayList<Song>();
        Cursor result = db.rawQuery("select * from "+ TABLE_NAME , null);
        while(result.moveToNext()){
            product.add( new Song(result.getString(result.getColumnIndex(COL_1)), result.getString(result.getColumnIndex(COL_2)),
                    result.getString(result.getColumnIndex(COL_3)),result.getString(result.getColumnIndex(COL_4)),
                    result.getString(result.getColumnIndex(COL_5)),result.getString(result.getColumnIndex(COL_6)),
                    result.getString(result.getColumnIndex(COL_7))));
        }
        return product;
    }
}
