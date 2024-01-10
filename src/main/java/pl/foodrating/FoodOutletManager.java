package pl.foodrating;

import java.util.List;

public class FoodOutletManager {
    private List<FoodOutlet> foodOutlets;

    public FoodOutletManager(List<FoodOutlet> foodOutlets) {
        this.foodOutlets = foodOutlets;
    }

    public List<FoodOutlet> getFoodOutlets() {
        return foodOutlets;
    }
}
