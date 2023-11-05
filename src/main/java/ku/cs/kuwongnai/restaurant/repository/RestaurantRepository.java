package ku.cs.kuwongnai.restaurant.repository;

import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository
        extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByUserId(Long id);
}
