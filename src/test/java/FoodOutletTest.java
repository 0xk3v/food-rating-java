
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pl.foodrating.FoodOutlet;
import pl.foodrating.Rating;


public class FoodOutletTest {

    @Test
    public void testCalculateAverageRatingWithNoRatings() {
        // Arrange
        FoodOutlet foodOutlet = new FoodOutlet("Test Outlet", "Test Address", "Test Cuisine", "Test Hours");

        // Act
        double averageRating = foodOutlet.calculateAverageRating();

        // Assert
        assertEquals(0.0, averageRating, 0.0001); // Allow a small delta for floating-point comparisons
    }


    @Test
    public void testCalculateAverageRatingWithMultipleRatings() {
        // Arrange
        FoodOutlet foodOutlet = new FoodOutlet("Test Outlet", "Test Address", "Test Cuisine", "Test Hours");
        Rating rating1 = new Rating( foodOutlet.getId(), 4);
        Rating rating2 = new Rating( foodOutlet.getId(), 5);
        Rating rating3 = new Rating( foodOutlet.getId(), 3);
        foodOutlet.addRating(rating1);
        foodOutlet.addRating(rating2);
        foodOutlet.addRating(rating3);

        // Act
        double averageRating = foodOutlet.calculateAverageRating();

        // Assert
        assertEquals(4.0, averageRating, 0.0001); // Allow a small delta for floating-point comparisons
    }
}
