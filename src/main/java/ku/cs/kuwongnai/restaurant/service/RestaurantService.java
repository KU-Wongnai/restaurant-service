package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.exception.InvalidOwnershipException;
import ku.cs.kuwongnai.restaurant.model.MenuOptionRequest;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import ku.cs.kuwongnai.restaurant.repository.MenuOptionRepository;
import ku.cs.kuwongnai.restaurant.repository.MenuRepository;
import ku.cs.kuwongnai.restaurant.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuOptionRepository menuOptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant createRestaurant(RestaurantRequest restaurant) {
        Restaurant record = modelMapper.map(restaurant, Restaurant.class);
        return restaurantRepository.save(record);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Restaurant not found with given ID = " + id));
    }

    public Restaurant updateRestaurant(Long id, RestaurantRequest requestBody) {
        Restaurant record = getRestaurantById(id);
        record.setName(requestBody.getName());
        record.setLocation(requestBody.getLocation());
        record.setDescription(requestBody.getDescription());
        record.setCategories(requestBody.getCategories());
        record.setContactInfo(requestBody.getContactInfo());
        record.setImage(requestBody.getImage());
        record.setRating(requestBody.getRating());
        return restaurantRepository.save(record);
    }

    public Restaurant deleteRestaurant(Long id) {
        Restaurant record = getRestaurantById(id);
        restaurantRepository.deleteById(id);
        return record;
    }

    /* ----------------------- For Menu ----------------------- */

    public List<Menu> getMenus(Long id) {
        Restaurant restaurant = getRestaurantById(id);
        return restaurant.getMenus();
    }

    public Menu createMenu(Long id, MenuRequest menu) {
        Menu record = modelMapper.map(menu, Menu.class);
        Restaurant restaurant = getRestaurantById(id);
        record.setRestaurant(restaurant);
        return menuRepository.save(record);
    }

    public Menu getMenuById(Long restaurantId, Long menuId) {
        Menu record = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Menu not found with given ID = " + menuId));

        // Check if menu belongs to specified restaurant
        if (!record.getRestaurant().getId().equals(restaurantId)) {
            throw new InvalidOwnershipException("This menu doesn't belong to specified restaurant");
        }

        return record;
    }

    public Menu updateMenu(Long restaurantId, Long menuId, MenuRequest requestBody) {
        Menu record = getMenuById(restaurantId, menuId);

        // Update menu
        record.setName(requestBody.getName());
        record.setDescription(requestBody.getDescription());
        record.setImage(requestBody.getImage());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());
        return menuRepository.save(record);
    }

    public Menu deleteMenu(Long restaurantId, Long menuId) {
        Menu record = getMenuById(restaurantId, menuId);
        menuRepository.deleteById(menuId);
        return record;
    }

    /* ----------------------- For Menu Option ----------------------- */

    public List<MenuOption> getMenuOptions(Long restaurantId, Long menuId) {
        Menu menu = getMenuById(restaurantId, menuId);
        return menu.getMenuOptions();
    }

    public MenuOption createMenuOption(Long restaurantId, Long menuId, MenuOptionRequest menuOption) {
        MenuOption record = modelMapper.map(menuOption, MenuOption.class);
        Menu menu = getMenuById(restaurantId, menuId);
        record.setMenu(menu);
        return menuOptionRepository.save(record);
    }

    public MenuOption getMenuOptionById(Long restaurantId, Long menuId, Long menuOptionId) {
        MenuOption record = menuOptionRepository.findById(menuOptionId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Menu option not found with given ID = " + menuOptionId));

        // Check if menu belongs to specified restaurant
        Menu menu = getMenuById(restaurantId, menuId);

        // Check if menu option belongs to specified menu
        if (!record.getMenu().getId().equals(menu.getId())) {
            throw new InvalidOwnershipException("This menu option doesn't belong to specified menu");
        }

        return record;
    }

    public MenuOption updateMenuOption(Long restaurantId, Long menuId, Long menuOptionId,
            MenuOptionRequest requestBody) {
        MenuOption record = getMenuOptionById(restaurantId, menuId, menuOptionId);
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());
        return menuOptionRepository.save(record);
    }

    public MenuOption deleteMenuOption(Long restaurantId, Long menuId, Long menuOptionId) {
        MenuOption record = getMenuOptionById(restaurantId, menuId, menuOptionId);
        menuOptionRepository.deleteById(menuOptionId);
        return record;
    }
}
