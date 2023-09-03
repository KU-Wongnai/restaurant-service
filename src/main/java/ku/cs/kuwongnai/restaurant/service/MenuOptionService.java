package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import ku.cs.kuwongnai.restaurant.model.MenuOptionRequest;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.repository.MenuOptionRepository;
import ku.cs.kuwongnai.restaurant.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuOptionService {

    @Autowired
    private MenuOptionRepository menuOptionRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MenuOption> getAllMenuOptions() {
        return menuOptionRepository.findAll();
    }

    public MenuOption createMenuOption(MenuOptionRequest menuOption) {
        MenuOption record = modelMapper.map(menuOption, MenuOption.class);
        Menu menu =
                menuRepository.findById(menuOption.getMenuId()).get();
        record.setMenu(menu);
        return menuOptionRepository.save(record);
    }

    public MenuOption updateMenuOption(Long id, MenuOptionRequest requestBody) {
        MenuOption record = menuOptionRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());
        return menuOptionRepository.save(record);
    }

    public MenuOption deleteMenuOption(Long id) {
        MenuOption record = menuOptionRepository.findById(id).get();
        menuOptionRepository.deleteById(id);
        return record;
    }

    public MenuOption getMenuOptionById(Long id) {
        return menuOptionRepository.findById(id).get();
    }

    public MenuOption getMenuOptionByName(String name) {
        return menuOptionRepository.findByName(name);
    }

    public List<MenuOption> getMenuOptionByCategory(String category) {
        return menuOptionRepository.findByCategory(category);
    }

    public List<MenuOption> getMenuOptionByPrice(double price) {
        return menuOptionRepository.findByPrice(price);
    }

    public List<MenuOption> getMenuOptionByMenuId(Long menuId) {
        return menuOptionRepository.findByMenuId(menuId);
    }


}
