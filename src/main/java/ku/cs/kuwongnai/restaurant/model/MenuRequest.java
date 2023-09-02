package ku.cs.kuwongnai.restaurant.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO Class for Menu
 */
@Data
public class MenuRequest {
    @NotBlank(message = "The name is required.")
    @Size(min = 3, max = 255)
    private String name;

    @Size(min = 6, max = 255)
    private String description;

    private Long restaurantId; // Foreign key

    private String image;

    @NotNull(message = "The price is required.")
    @Positive
    private double price;

    @NotBlank(message = "The category is required.")
    @Size(min = 3, max = 255)
    private String category;
}
