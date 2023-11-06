package ku.cs.kuwongnai.restaurant.entity;

import ku.cs.kuwongnai.restaurant.common.RestaurantCategory;
import ku.cs.kuwongnai.restaurant.common.RestaurantStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {

    @Test
    public void testRestaurantCreation() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setDescription("This is a test restaurant.");
        restaurant.setLocation("Test Location");
        restaurant.setCategories(List.of(RestaurantCategory.FAST_FOOD, RestaurantCategory.NOODLE));
        restaurant.setStatus(RestaurantStatus.PENDING);
        restaurant.setContactInfo("Test Contact Info");
        restaurant.setImage("test.jpg");

        // Perform assertions to test the restaurant attributes
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals("This is a test restaurant.", restaurant.getDescription());
        assertEquals("Test Location", restaurant.getLocation());
        assertEquals(List.of(RestaurantCategory.FAST_FOOD, RestaurantCategory.NOODLE), restaurant.getCategories());
        assertEquals(RestaurantStatus.PENDING, restaurant.getStatus());
        assertEquals("Test Contact Info", restaurant.getContactInfo());
        assertEquals("test.jpg", restaurant.getImage());
    }

    @Test
    public void testMenuCreation() {
        Menu menu = new Menu();
        menu.setName("Test Menu");
        menu.setDescription("This is a test menu.");
        menu.setPrice(100.0);
        menu.setImage("test.jpg");

        // Perform assertions to test the menu attributes
        assertEquals("Test Menu", menu.getName());
        assertEquals("This is a test menu.", menu.getDescription());
        assertEquals(100.0, menu.getPrice());
        assertEquals("test.jpg", menu.getImage());
    }

}
