package ku.cs.kuwongnai.restaurant.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public Restaurant create(@RequestBody RestaurantRequest restaurant) {
        return service.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant update(@PathVariable Long id, @RequestBody RestaurantRequest restaurant) {
        return service.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public ObjectNode delete(@PathVariable Long id) {
        return service.deleteRestaurant(id);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return service.getRestaurantById(id);
    }

    @GetMapping("/name/{name}")
    public Restaurant getRestaurantByName(@PathVariable String name) {
        return service.getRestaurantByName(name);
    }

    @GetMapping("/location/{location}")
    public List<Restaurant> getRestaurantByLocation(@PathVariable String location) {
        return service.getRestaurantByLocation(location);
    }

    @GetMapping("/foodType/{foodType}")
    public List<Restaurant> getRestaurantByFoodType(@PathVariable String foodType) {
        return service.getRestaurantByFoodType(foodType);
    }

    @GetMapping("/rating/{rating}")
    public List<Restaurant> getRestaurantByRating(@PathVariable double rating) {
        return service.getRestaurantByRating(rating);
    }
}
