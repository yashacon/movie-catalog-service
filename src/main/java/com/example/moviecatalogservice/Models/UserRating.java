package com.example.moviecatalogservice.Models;

import java.util.List;

public class UserRating {
    public UserRating(){}
    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
