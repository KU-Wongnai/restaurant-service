package ku.cs.kuwongnai.restaurant.controller;

import jakarta.validation.Valid;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import ku.cs.kuwongnai.restaurant.model.MenuOptionRequest;
import ku.cs.kuwongnai.restaurant.service.MenuOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menuOptions")
public class MenuOptionController {

    @Autowired
    private MenuOptionService service;

    @GetMapping
    public List<MenuOption> getAllMenuOptions() {
        return service.getAllMenuOptions();
    }

    @PostMapping
    public ResponseEntity<MenuOption> create(@Valid @RequestBody MenuOptionRequest menuOption) {
        MenuOption createdMenuOption = service.createMenuOption(menuOption);
        return new ResponseEntity<>(createdMenuOption, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuOption> update(@Valid @PathVariable Long id, @RequestBody MenuOptionRequest menuOption) {
        MenuOption updatedMenuOption = service.updateMenuOption(id, menuOption);
        return new ResponseEntity<>(updatedMenuOption, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MenuOption> delete(@PathVariable Long id) {
        MenuOption deletedMenuOption = service.deleteMenuOption(id);
        return new ResponseEntity<>(deletedMenuOption, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MenuOption getMenuOptionById(@PathVariable Long id) {
        return service.getMenuOptionById(id);
    }

    @GetMapping("/name/{name}")
    public MenuOption getMenuOptionByName(@PathVariable String name) {
        return service.getMenuOptionByName(name);
    }

    @GetMapping("/category/{category}")
    public List<MenuOption> getMenuOptionByCategory(@PathVariable String category) {
        return service.getMenuOptionByCategory(category);
    }

    @GetMapping("/price/{price}")
    public List<MenuOption> getMenuOptionByPrice(@PathVariable double price) {
        return service.getMenuOptionByPrice(price);
    }
}
