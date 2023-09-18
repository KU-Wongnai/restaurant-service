package ku.cs.kuwongnai.restaurant.controller;

import jakarta.validation.Valid;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuOptionRequest;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.publisher.RabbitMQPublisher;
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

    @Autowired
    private RabbitMQPublisher publisher;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = service.getAllRestaurant();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@Valid @RequestBody RestaurantRequest restaurant) {
        Restaurant createdRestaurant = service.createRestaurant(restaurant);
        publisher.publishJson("events.restaurant", "restaurant.created", createdRestaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = service.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @Valid @RequestBody RestaurantRequest restaurant) {
        Restaurant updatedRestaurant = service.updateRestaurant(id, restaurant);
        publisher.publishJson("events.restaurant", "restaurant.updated", updatedRestaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurant> delete(@PathVariable Long id) {
        Restaurant deletedRestaurant = service.deleteRestaurant(id);
        publisher.publishId("events.restaurant", "restaurant.deleted", id);
        return new ResponseEntity<>(deletedRestaurant, HttpStatus.OK);
    }

    /* ----------------------- For Menu ----------------------- */

    @GetMapping("/{id}/menu")
    public ResponseEntity<List<Menu>> getMenus(@PathVariable Long id) {
        List<Menu> menus = service.getMenus(id);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("/{id}/menu")
    public ResponseEntity<Menu> createMenu(@PathVariable Long id, @Valid @RequestBody MenuRequest menu) {
        Menu createdMenu = service.createMenu(id, menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}/menu/items/{menuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long restaurantId, @PathVariable Long menuId) {
        Menu menu = service.getMenuById(restaurantId, menuId);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PutMapping("/{restaurantId}/menu/items/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long restaurantId, @PathVariable Long menuId,
            @Valid @RequestBody MenuRequest menu) {
        Menu updatedMenu = service.updateMenu(restaurantId, menuId, menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/{restaurantId}/menu/items/{menuId}")
    public ResponseEntity<Menu> deleteMenu(@PathVariable Long restaurantId, @PathVariable Long menuId) {
        Menu deletedMenu = service.deleteMenu(restaurantId, menuId);
        return new ResponseEntity<>(deletedMenu, HttpStatus.OK);
    }

    /* ----------------------- For Menu Option ----------------------- */

    @GetMapping("/{restaurantId}/menu/items/{menuId}/options")
    public ResponseEntity<List<MenuOption>> getMenuOptions(@PathVariable Long restaurantId,
            @PathVariable Long menuId) {
        List<MenuOption> menuOptions = service.getMenuOptions(restaurantId, menuId);
        return new ResponseEntity<>(menuOptions, HttpStatus.OK);
    }

    @PostMapping("/{restaurantId}/menu/items/{menuId}/options")
    public ResponseEntity<MenuOption> createMenuOption(@PathVariable Long restaurantId, @PathVariable Long menuId,
            @Valid @RequestBody MenuOptionRequest menuOption) {
        MenuOption createdMenuOption = service.createMenuOption(restaurantId, menuId, menuOption);
        return new ResponseEntity<>(createdMenuOption, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}")
    public ResponseEntity<MenuOption> getMenuOptionById(@PathVariable Long restaurantId,
            @PathVariable Long menuId,
            @PathVariable Long menuOptionId) {
        MenuOption menuOption = service.getMenuOptionById(restaurantId, menuId, menuOptionId);
        return new ResponseEntity<>(menuOption, HttpStatus.OK);
    }

    @PutMapping("/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}")
    public ResponseEntity<MenuOption> updateMenuOption(@PathVariable Long restaurantId, @PathVariable Long menuId,
            @PathVariable Long menuOptionId,
            @Valid @RequestBody MenuOptionRequest menuOption) {
        MenuOption updatedMenuOption = service.updateMenuOption(restaurantId, menuId, menuOptionId, menuOption);
        return new ResponseEntity<>(updatedMenuOption, HttpStatus.OK);
    }

    @DeleteMapping("/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}")
    public ResponseEntity<MenuOption> deleteMenuOption(@PathVariable Long restaurantId, @PathVariable Long menuId,
            @PathVariable Long menuOptionId) {
        MenuOption deletedMenuOption = service.deleteMenuOption(restaurantId, menuId, menuOptionId);
        return new ResponseEntity<>(deletedMenuOption, HttpStatus.OK);
    }
}
