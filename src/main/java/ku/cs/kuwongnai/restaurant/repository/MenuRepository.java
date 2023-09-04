package ku.cs.kuwongnai.restaurant.repository;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
