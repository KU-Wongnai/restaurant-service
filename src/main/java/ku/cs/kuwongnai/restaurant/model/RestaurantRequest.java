package ku.cs.kuwongnai.restaurant.model;

import lombok.Data;

/**
 * DTO Class for Menu
 */
@Data
public class RestaurantRequest {
    private String name;
    private String description;
    private String location;
    private String foodType;
    private int operatingHours;
    private String contactInfo;
    private String image;
    //    private Integer numReviews;
    private double rating;
}
