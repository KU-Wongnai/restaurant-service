package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String location;
    private String foodType;
    private int operatingHours;
    private String contactInfo;
    private String image;
    //    private Integer numReviews;
    private double rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Menu> menus = new ArrayList<>();
}
