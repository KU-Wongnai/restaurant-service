package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    List<MenuOption> menuOptions = new ArrayList<>();
}
