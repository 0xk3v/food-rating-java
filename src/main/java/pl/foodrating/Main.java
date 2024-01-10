package pl.foodrating;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FoodOutlet> foodOutlets = DataService.loadSampleData("sample_data.txt");
        FoodOutletManager outletManager = new FoodOutletManager(foodOutlets);
        Menu menu = new Menu(outletManager);
        menu.displayMenu();
    }
}