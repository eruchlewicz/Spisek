package com.example.ewelina.spisek;

/**
 * Created by Ewelina on 2017-10-09.
 */

public class Song {

    public Song(String id, String title, String songbook, String page, String number, String lyrics, String chords){
        this.id = id;
        this.title = title;
        this.songbook = songbook;
        this.page = page;
        this.number = number;
        this.lyrics = lyrics;
        this.chords = chords;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String songbook;

    public String getSongbook() { return songbook; }

    public void setSongbook(String songbook) {
        this.songbook = songbook;
    }

    private String page;

    public String getPage() { return page; }

    public void setPage(String price) { this.page = page; }

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String lyrics;

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    private String chords;

    public String getChords() {
        return chords;
    }

    public void setChords(String chords) {
        this.chords = chords;
    }
}
