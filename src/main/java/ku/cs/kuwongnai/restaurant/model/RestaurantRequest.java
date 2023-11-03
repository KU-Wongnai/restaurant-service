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

    @Size(min = 3, max = 20)
    private int minPrice;
    @Size(min = 3, max = 20)
    private int maxPrice;
    private Boolean isDelivery;
    private Boolean isWalkIn;

    private String priceRange;

    @Email
    private String email;
    private String facebook;
    private String line;
    private String instagram;
    private String website;

    private List<Day> openDays;

    // @Positive
    // @Max(5)
    // private double rating;

    // TODO : Add more attributes
}
