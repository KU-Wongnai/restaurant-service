package ku.cs.kuwongnai.restaurant.repository;

import ku.cs.kuwongnai.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
