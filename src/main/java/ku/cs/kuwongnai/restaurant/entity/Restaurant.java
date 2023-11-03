package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import ku.cs.kuwongnai.restaurant.common.RestaurantCategory;
import ku.cs.kuwongnai.restaurant.common.RestaurantStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    private User user;

    private String name;
    private String description;
    private String location;
    private List<RestaurantCategory> categories;
    private RestaurantStatus status;
    private String dayAvailable;
    private String openAt;
    private String closeAt;
    private String phone;
    private String image;
    private int minPrice;
    private int maxPrice;

    @Positive
    @Max(5)
    private double rating;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Menu> menus = new ArrayList<>();
}
