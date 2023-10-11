package ku.cs.kuwongnai.restaurant.model;

import ku.cs.kuwongnai.restaurant.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Menu class used for publishing to RabbitMQ
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuPublish extends Menu {

  Long restaurantId;

  public MenuPublish(Menu menu) {
    this.setId(menu.getId());
    this.setName(menu.getName());
    this.setDescription(menu.getDescription());
    this.setImage(menu.getImage());
    this.setPrice(menu.getPrice());
    this.setCategory(menu.getCategory());
  }
}
