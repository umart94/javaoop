package com.umar;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist, ArrayList<Song> songs) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
    }
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            this.songs.add( new)
        }
    }

}
