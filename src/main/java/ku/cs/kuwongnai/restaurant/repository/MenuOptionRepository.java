package ku.cs.kuwongnai.restaurant.repository;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import ku.cs.kuwongnai.restaurant.entity.MenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {
    MenuOption findByName(String name);
    List<MenuOption> findByCategory(String category);
    List<MenuOption> findByPrice(double price);
    List<MenuOption> findByMenuId(Long menuId);

}
