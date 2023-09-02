package ku.cs.kuwongnai.restaurant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.repository.MenuRepository;
import ku.cs.kuwongnai.restaurant.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public Restaurant createRestaurant(RestaurantRequest restaurant) {
        Restaurant record = modelMapper.map(restaurant, Restaurant.class);
        return restaurantRepository.save(record);
    }

    public Restaurant updateRestaurant(Long id, RestaurantRequest requestBody) {
        Restaurant record = restaurantRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setLocation(requestBody.getLocation());
        record.setDescription(requestBody.getDescription());
        record.setFoodType(requestBody.getFoodType());
        record.setOperatingHours(requestBody.getOperatingHours());
        record.setContactInfo(requestBody.getContactInfo());
        record.setImage(requestBody.getImage());
        record.setRating(requestBody.getRating());
        return restaurantRepository.save(record);
    }

    public ObjectNode deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
        ObjectNode response = objectMapper.createObjectNode();
        response.put("message", "Restaurant ID " + id + " deleted successfully");
        response.put("success", true);
        return response;
    }

    public Menu createMenu(Long id, MenuRequest menu) {
        Menu record = modelMapper.map(menu, Menu.class);
        Restaurant restaurant = restaurantRepository.findById(id).get();
        record.setRestaurant(restaurant);
        return menuRepository.save(record);
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).get();
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }

    public List<Restaurant> getRestaurantByLocation(String location) {
        return restaurantRepository.findByLocation(location);
    }

    public List<Restaurant> getRestaurantByFoodType(String foodType) {
        return restaurantRepository.findByFoodType(foodType);
    }

    public List<Restaurant> getRestaurantByRating(double rating) {
        return restaurantRepository.findByRating(rating);
    }
}
