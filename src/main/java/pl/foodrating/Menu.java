package pl.foodrating;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private FoodOutletManager outletManager;

    public Menu(FoodOutletManager outletManager) {
        this.scanner = new Scanner(System.in);
        this.outletManager = outletManager;
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("------ Food Outlet Rating System ------");
            System.out.println("1. View Food Outlets");
            System.out.println("2. Add Rating and Review");
            System.out.println("3. Load Sample Data");
            System.out.println("4. Save Sample Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewFoodOutlets();
                    break;
                case 2:
                    addRatingAndReview();
                    break;
                case 3:
                    loadSampleData();
                    break;
                case 4:
                    saveSampleData();
                    break;
                case 0:
                    System.out.println("Exiting the Food Outlet Rating System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void viewFoodOutlets() {
        List<FoodOutlet> foodOutlets = outletManager.getFoodOutlets();
        System.out.println("------ View Food Outlets ------");
        for (FoodOutlet outlet : foodOutlets) {
            System.out.println("ID: " + outlet.getId());
            System.out.println("Name: " + outlet.getName());
            System.out.println("Address: " + outlet.getAddress());
            System.out.println("Cuisine Type: " + outlet.getCuisineType());
            System.out.println("Opening Hours: " + outlet.getOpeningHours());
            System.out.println("Average Rating: " + outlet.calculateAverageRating());
            System.out.println("---------------------------");
        }
    }

    private void addRatingAndReview() {
        viewFoodOutlets();
        System.out.print("Enter the ID of the food outlet you want to review: ");
        int outletId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        FoodOutlet selectedOutlet = findFoodOutletById(outletId);
        if (selectedOutlet != null) {
            System.out.print("Enter your rating (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter your review: ");
            String review = scanner.nextLine();

            RatingReview newReview = new RatingReview(1, outletId, rating, review);
            selectedOutlet.addReview(newReview);
            System.out.println("Rating and review added successfully for " + selectedOutlet.getName());
        } else {
            System.out.println("Food outlet with ID " + outletId + " not found.");
        }
    }

    private FoodOutlet findFoodOutletById(int outletId) {
        List<FoodOutlet> foodOutlets = outletManager.getFoodOutlets();
        for (FoodOutlet outlet : foodOutlets) {
            if (outlet.getId() == outletId) {
                return outlet;
            }
        }
        return null;
    }

    private void loadSampleData() {
        List<FoodOutlet> loadedFoodOutlets = DataService.loadSampleData("sample_data.txt");
        outletManager = new FoodOutletManager(loadedFoodOutlets);
    }

    private void saveSampleData() {
        DataService.saveSampleData(outletManager.getFoodOutlets(), "sample_data.txt");
        System.out.println("Sample data saved successfully.");
    }
}
