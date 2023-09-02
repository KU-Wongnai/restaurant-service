# Restaurant Service
CRUD api for restaurant, restaurant menu and menu options

## Built With

* [![Spring][Spring.io]][Spring-url]
* [![Spring Boot][Spring.io/spring-boot]][Spring-url]

## Setup
1. Clone the repo
    ```sh
    git clone https://github.com/KU-Wongnai/restaurant-service.git
    ```
2. Run `RestaurantApplication.java` to start the service

## API
Service runs at http://localhost:8092

## Restaurant
*Make sure to create a restaurant before creating a menu*
### Create
> POST -> http://localhost:8092/api/restaurants
```json
{
    "name" : "Sushi Power",
    "description" : "Have some sushi",
    "location" : "Bangkhen",
    "foodType" : "Japanese",
    "operatingHours" : 3,
    "contactInfo" : "0998765431",
    "rating" : 4.8
}
```

### Show All
> GET -> http://localhost:8092/api/restaurants

### Get by ID
> GET -> http://localhost:8092/api/restaurants/{id}

### Get by Name
> GET -> http://localhost:8092/api/restaurants/name/{name}

### Update
> PUT -> http://localhost:8092/api/restaurants/{id}
```json
{
    "name": "Teenoi",
    "description": "Have some shabu",
    "location": "Ladprao",
    "foodType": "Thai",
    "operatingHours": 4,
    "contactInfo": "0998765432",
    "image": null,
    "rating": 4.9
}
```

### Delete
> DELETE -> http://localhost:8092/api/restaurants/{id}

## Menu

### Create
> POST -> http://localhost:8092/api/menus
```json
{
  "name" : "Sushi",
  "restaurantId" : 1,
  "description" : "Very delicious",
  "image" : null,
  "price" : 250,
  "category" : "Japanese"
}
```

### Show All
> GET -> http://localhost:8092/api/menus

### Get by ID
> GET -> http://localhost:8092/api/menus/{id}

### Get by Name
> GET -> http://localhost:8092/api/menus/name/{name}

### Get by Category
> GET -> http://localhost:8092/api/menus/category/{category}

### Get by Price
> GET -> http://localhost:8092/api/menus/price/{price}

### Update
> PUT -> http://localhost:8092/api/restaurants/{id}
```json
{
  "name" : "Sashimi",
  "description" : "Super delicious",
  "image" : null,
  "price" : 500,
  "category" : "Japanese"
}
```
*Cannot update restaurant id because the menu is not supposed to go to another restaurant*

### Delete
> DELETE -> http://localhost:8092/api/menus/{id}

<!-- MARKDOWN LINKS & IMAGES -->
[Spring.io]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io
[Spring.io/spring-boot]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[Spring-Boot-url]: https://spring.io/projects/spring-boot

<p align="right">(<a href="#readme-top">back to top</a>)</p>