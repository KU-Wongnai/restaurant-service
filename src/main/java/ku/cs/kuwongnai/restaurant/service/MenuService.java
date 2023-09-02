package ku.cs.kuwongnai.restaurant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.repository.MenuRepository;
import ku.cs.kuwongnai.restaurant.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu createMenu(MenuRequest menu) {
        Menu record = modelMapper.map(menu, Menu.class);
        Restaurant restaurant =
                restaurantRepository.findById(menu.getRestaurantId()).get();
        record.setRestaurant(restaurant);
        return menuRepository.save(record);
    }

    public Menu updateMenu(Long id, Menu requestBody) {
        Menu record = menuRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setDescription(requestBody.getDescription());
        record.setImage(requestBody.getImage());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());
        return menuRepository.save(record);
    }

    public ObjectNode deleteMenu(Long id) {
        menuRepository.deleteById(id);
        ObjectNode response = objectMapper.createObjectNode();
        response.put("message", "Menu ID " + id + " deleted successfully");
        response.put("success", true);
        return response;
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).get();
    }

    public Menu getMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    public List<Menu> getMenuByCategory(String category) {
        return menuRepository.findByCategory(category);
    }

    public List<Menu> getMenuByPrice(double price) {
        return menuRepository.findByPrice(price);
    }

    public List<Menu> getMenuByRestaurantId(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }
}
