package ku.cs.kuwongnai.restaurant.model;

import jakarta.validation.constraints.*;
import ku.cs.kuwongnai.restaurant.common.RestaurantCategory;
import lombok.Data;

import java.util.List;

/**
 * DTO Class for Menu
 */
@Data
public class RestaurantRequest {
    @NotBlank(message = "The name is required.")
    @Size(min = 3, max = 255)
    private String name;

    @Size(min = 7, max = 255)
    private String description;

    @Size(min = 3, max = 255)
    private String location;

    // @NotBlank(message = "The food categories is required.")
    // @Size(min = 3, max = 255)
    @NotEmpty(message = "The food categories is required.")
    private List<RestaurantCategory> categories;

    @Size(min = 3, max = 255)
    private String contactInfo;

    private String image;

    @Positive
    @Max(5)
    private double rating;

    // TODO : Add more attributes
}
