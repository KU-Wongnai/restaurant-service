package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.repository.MenuRepository;
import ku.cs.kuwongnai.restaurant.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    public Menu deleteMenu(Long id) {
        Menu record = menuRepository.findById(id).get();
        menuRepository.deleteById(id);
        return record;
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
