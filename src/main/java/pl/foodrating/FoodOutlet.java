package pl.foodrating;

import java.util.ArrayList;
import java.util.List;

public class FoodOutlet {
    private static int nextId = 1;

    private int id;
    private String name;
    private String address;
    private String cuisineType;
    private String openingHours;
    private List<Rating> ratings;

    public FoodOutlet(String name, String address, String cuisineType, String openingHours) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.openingHours = openingHours;
        this.ratings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public double calculateAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }

        int totalRating = 0;
        for (Rating rating : ratings) {
            totalRating += rating.getRating();
        }

        return (double) totalRating / ratings.size();
    }
}
