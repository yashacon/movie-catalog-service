package com.example.moviecatalogservice.Models;

public class Movies {
    public String movieId;
    public String name;
    public String desc;


    public String getDesc() {
        return desc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movies(){

    }
    public Movies(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }
}
