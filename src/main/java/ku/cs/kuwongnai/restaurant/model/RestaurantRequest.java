package ku.cs.kuwongnai.restaurant.model;

import jakarta.validation.constraints.*;
import ku.cs.kuwongnai.restaurant.common.Day;
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

    @Size(min = 3, max = 255)
    private String description;

    @NotBlank(message = "The location is required.")
    @Size(min = 3, max = 255)
    private String location;

    @Size(min = 3, max = 20)
    private String dayAvailable;

    @Size(min = 3, max = 20)
    private String openAt;

    @Size(min = 3, max = 20)
    private String closeAt;

    @NotEmpty(message = "The food categories is required.")
    @Size(max = 5)
    private List<RestaurantCategory> categories;

    @Size(min = 8, max = 11)
    private String phone;

    private String image;


    private Boolean isDelivery;
    private Boolean isWalkIn;

    @Min(value = 0, message = "minPrice must be greater than or equal to 0")
    private Integer minPrice;

    @Max(value = 1000, message = "maxPrice must be less than or equal to 1000")
    private Integer maxPrice;
    
    private String priceRange;

    @Email
    private String email;
    @Size(max = 255)
    private String facebook;
    @Size(max = 255)
    private String line;
    @Size(max = 255)
    private String instagram;

    @Size(max = 255)
    private String website;

    private List<Day> openDays;

    // TODO : Add more attributes
}
