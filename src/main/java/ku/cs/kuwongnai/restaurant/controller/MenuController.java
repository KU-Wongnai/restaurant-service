package ku.cs.kuwongnai.restaurant.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import ku.cs.kuwongnai.restaurant.model.MenuOptionRequest;
import ku.cs.kuwongnai.restaurant.model.MenuRequest;
import ku.cs.kuwongnai.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping
    public List<Menu> getAllMenus() {
        return service.getAllMenus();
    }

    @PostMapping
    public ResponseEntity<Menu> create(@Valid @RequestBody MenuRequest menu) {
        Menu createdMenu = service.createMenu(menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@Valid @PathVariable Long id, @RequestBody MenuRequest menu) {
        Menu updatedMenu = service.updateMenu(id, menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Menu> delete(@PathVariable Long id) {
        Menu deletedMenu = service.deleteMenu(id);
        return new ResponseEntity<>(deletedMenu, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<MenuOption> createMenuOption(@PathVariable Long id, @Valid @RequestBody MenuOptionRequest menuOption) {
        MenuOption createdMenuOption = service.createMenuOption(id, menuOption);
        return new ResponseEntity<>(createdMenuOption, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return service.getMenuById(id);
    }

    @GetMapping("/name/{name}")
    public Menu getMenuByName(@PathVariable String name) {
        return service.getMenuByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Menu> getMenuByCategory(@PathVariable String category) {
        return service.getMenuByCategory(category);
    }

    @GetMapping("/price/{price}")
    public List<Menu> getMenuByPrice(@PathVariable double price) {
        return service.getMenuByPrice(price);
    }

}
