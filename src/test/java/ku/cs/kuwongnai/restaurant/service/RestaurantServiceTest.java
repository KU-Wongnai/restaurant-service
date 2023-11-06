package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.common.RestaurantCategory;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.entity.User;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private UserService userService; // Mock the UserService

    @Test
    public void testGetAllRestaurant() {
        // Mock the repository to return a list of restaurants when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes
        Mockito.when(restaurantRepository.findAll()).thenReturn(List.of(mockRestaurant));
        // Call the getAllRestaurant method and assert the result
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();
        // Use JUnit assertions to check the size of the returned list
        assertEquals(1, restaurants.size());
    }

    @Test
    public void testCreateRestaurant() {
        // Mock the repository to return a restaurant when saved
        RestaurantRequest restaurantRequest = new RestaurantRequest();
        // Set restaurantRequest attributes
        Restaurant mockRestaurant = new Restaurant();
        // Set mockRestaurant attributes

        // Mock the behavior of the UserService
        User mockUser = new User();
        mockUser.setId(1L); // Set the user ID to match the test
        Mockito.when(userService.getById(1L)).thenReturn(mockUser);

        Mockito.when(restaurantRepository.save(Mockito.any(Restaurant.class))).thenReturn(mockRestaurant);

        // Call the createRestaurant method and assert the result
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurantRequest, 1L);
        // assert that the restaurant is created
        assertThat(createdRestaurant).isNotNull();
    }

    @Test
    public void testGetRestaurantById() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        // Call the getRestaurantById method and assert the result
        Restaurant restaurant = restaurantService.getRestaurantById(1L);
        // Use JUnit assertions to check
        assertEquals(1L, restaurant.getId());
    }

    @Test
    public void testGetRestaurantByUserId() {
        // Mock the repository to return a list of restaurants when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findByUserId(1L)).thenReturn(List.of(mockRestaurant));

        // Call the getRestaurantByUserId method and assert the result
        List<Restaurant> restaurants = restaurantService.getRestaurantByUserId(1L);
        // Use JUnit assertions to check
        assertEquals(1, restaurants.size());
    }

    @Test
    public void testUpdateRestaurant() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        RestaurantRequest restaurantRequest = new RestaurantRequest();
        // Set restaurantRequest attributes
        restaurantRequest.setName("new name");
        restaurantRequest.setLocation("new location");
        restaurantRequest.setDescription("new description");
        restaurantRequest.setCategories(List.of(RestaurantCategory.FAST_FOOD, RestaurantCategory.NOODLE));
        restaurantRequest.setPhone("new phone");
        restaurantRequest.setImage("new image");


        // Call the updateRestaurant method and assert the result
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(1L, restaurantRequest);
        // check that the restaurant is updated
        assertEquals("new name", updatedRestaurant.getName());
        assertEquals("new location", updatedRestaurant.getLocation());
        assertEquals("new description", updatedRestaurant.getDescription());
        assertEquals(List.of(RestaurantCategory.FAST_FOOD, RestaurantCategory.NOODLE), updatedRestaurant.getCategories());
        assertEquals("new phone", updatedRestaurant.getPhone());
        assertEquals("new image", updatedRestaurant.getImage());

    }

    @Test
    public void testAcceptRestaurant() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        // Call the acceptRestaurant method and assert the result
        Restaurant acceptedRestaurant = restaurantService.acceptRestaurant(1L);
        // Use JUnit assertions to check
        assertEquals(1L, acceptedRestaurant.getId());
    }

    @Test
    public void testDeclineRestaurant() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        // Call the declineRestaurant method and assert the result
        Restaurant declinedRestaurant = restaurantService.declineRestaurant(1L);
        // Use JUnit assertions to check
        assertEquals(1L, declinedRestaurant.getId());
    }

    @Test
    public void testGetMenus() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        // Call the getMenus method and assert the result
        List<Menu> menus = restaurantService.getMenus(1L);
        // Use JUnit assertions to check
        assertEquals(0, menus.size());
    }

    @Test
    public void testCreateMenu() {
        // Mock the repository to return a restaurant when queried
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(1L);
        // Set other mockRestaurant attributes

        Mockito.when(restaurantRepository.findById(1L)).thenReturn(Optional.of(mockRestaurant));

        MenuRequest mockMenu = new MenuRequest();
        // Set other mockMenu attributes
        mockMenu.setName("Test Menu");
        mockMenu.setDescription("This is a test menu.");
        mockMenu.setPrice(100.0);
        mockMenu.setImage("test.jpg");

        Mockito.when(restaurantRepository.save(Mockito.any(Restaurant.class))).thenReturn(mockRestaurant);

        // Call the createMenu method and assert the result
        Menu createdMenu = restaurantService.createMenu(1L, mockMenu);
        // Use JUnit assertions to check
        assertEquals("Test Menu", createdMenu.getName());
    }

}
