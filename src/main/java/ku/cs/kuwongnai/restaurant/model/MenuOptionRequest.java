package ku.cs.kuwongnai.restaurant.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO Class for Menu Option
 */
@Data
public class MenuOptionRequest {
    @NotBlank(message = "The name is required.")
    @Size(min = 3, max = 255)
    private String name;

    private Long menuId; // Foreign key

    @NotNull(message = "The price is required.")
    @Positive
    private double price;

    @NotBlank(message = "The category is required.")
    @Size(min = 3, max = 255)
    private String category;
}
