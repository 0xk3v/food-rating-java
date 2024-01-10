package pl.foodrating;

public class RatingReview {
    private static int nextId = 1;

    private int id;
    private int userId;
    private int outletId;
    private int rating;
    private String review;
    private long timestamp;

    // Constructor
    public RatingReview(int userId, int outletId, int rating, String review) {
        this.id = nextId++;
        this.userId = userId;
        this.outletId = outletId;
        this.rating = rating;
        this.review = review;
        this.timestamp = System.currentTimeMillis(); // Timestamp in milliseconds
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getOutletId() {
        return outletId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
