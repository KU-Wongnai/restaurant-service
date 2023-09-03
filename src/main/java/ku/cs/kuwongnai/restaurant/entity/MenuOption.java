package ku.cs.kuwongnai.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MenuOption {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private String category;

    @JsonBackReference
    @ManyToOne
    private Menu menu;
}
