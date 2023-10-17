package ku.cs.kuwongnai.restaurant.model;

import lombok.Data;

@Data
public class MenuOptionPublish {

  private Long id;
  private String name;
  private double price;
  private String category;

  private Long menuId;
}
