package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    private String foodType;
//    private LocalTime openAt;
//    private LocalTime closeAt;
    private String contactInfo;
    private String image;
    //    private Integer numReviews;
    private double rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Menu> menus = new ArrayList<>();

//    public String getOpeningHours()  {
//        return openAt.toString() + " - " + closeAt.toString();
//    }
}
