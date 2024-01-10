package pl.foodrating;

public class Rating {
    private static int nextId = 1;

    private int id;
    private int outletId;
    private int rating;

    public Rating(int outletId, int rating) {
        this.id = nextId++;
        this.outletId = outletId;
        this.rating = rating;
    }

    public int getId() {
        return id;
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

}
