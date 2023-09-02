package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
    private String category;

    @JsonBackReference
    @ManyToOne
    private Restaurant restaurant;
}
