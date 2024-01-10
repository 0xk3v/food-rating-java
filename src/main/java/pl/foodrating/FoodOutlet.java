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
    private List<RatingReview> reviews;

    // Constructor
    public FoodOutlet(String name, String address, String cuisineType, String openingHours) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.openingHours = openingHours;
        this.reviews = new ArrayList<>();
    }

    // Getters and Setters
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

    public List<RatingReview> getReviews() {
        return reviews;
    }

    // Method to add a review to the food outlet
    public void addReview(RatingReview review) {
        reviews.add(review);
    }

    // Method to calculate the average rating of the food outlet
    public double calculateAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }

        int totalRating = 0;
        for (RatingReview review : reviews) {
            totalRating += review.getRating();
        }

        return (double) totalRating / reviews.size();
    }
}
