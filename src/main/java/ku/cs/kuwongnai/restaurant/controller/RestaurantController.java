package ku.cs.kuwongnai.restaurant.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.service.MenuService;
import ku.cs.kuwongnai.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity<Restaurant> create(@Valid @RequestBody RestaurantRequest restaurant) {
        Restaurant createdRestaurant = service.createRestaurant(restaurant);

        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @Valid @RequestBody RestaurantRequest restaurant) {
        Restaurant updatedRestaurant = service.updateRestaurant(id, restaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurant> delete(@PathVariable Long id) {
        Restaurant deletedRestaurant = service.deleteRestaurant(id);
        return new ResponseEntity<>(deletedRestaurant, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Menu> createMenu(@PathVariable Long id, @Valid @RequestBody MenuRequest menu) {
        Menu createdMenu = service.createMenu(id, menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
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
