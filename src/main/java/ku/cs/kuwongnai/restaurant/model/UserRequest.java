package ku.cs.kuwongnai.restaurant.model;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRequest {
    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDateTime emailVerifiedAt;
}
