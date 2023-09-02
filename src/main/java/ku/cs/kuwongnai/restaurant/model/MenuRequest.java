package ku.cs.kuwongnai.restaurant.model;

import lombok.Data;

/**
 * DTO Class for Menu
 */
@Data
public class MenuRequest {
    private String name;
    private String description;

    private Long restaurantId; // Foreign key

    private String image;
    private double price;
    private String category;
}
