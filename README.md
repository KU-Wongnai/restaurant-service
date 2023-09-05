# KU Wongnai - Restaurant Service
CRUD api for restaurant, restaurant menu and menu options

## Table of Contents
* [Built With](#built-with)
* [Setup](#setup)
* [API](#api)
  * [Restaurant](#restaurant)
  * [Menu](#menu)
  * [Menu Option](#menu-option)

## Built With

* [![Spring][Spring.io]][Spring-url]
* [![Spring Boot][Spring.io/spring-boot]][Spring-url]

## Setup
1. Run the following command to start MySQL Server at port 3307.
    ```sh
    docker-compose up -d
    ```
2. Clone the repo
    ```sh
    git clone https://github.com/KU-Wongnai/restaurant-service.git
    ```
3. Run `RestaurantApplication.java` to start the service

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

### Show All Restaurants
> GET -> http://localhost:8092/api/restaurants

### Find Restaurant by ID
> GET -> http://localhost:8092/api/restaurants/{restaurantId}

### Update Restaurant
> PUT -> http://localhost:8092/api/restaurants/{restaurantId}
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

### Delete Restaurant
> DELETE -> http://localhost:8092/api/restaurants/{restaurantId}

([back to top][readme-top])

## Menu
*Make sure to create a restaurant before creating a menu*

### Create Menu
> POST -> http://localhost:8092/api/restaurants/{restaurantId}/menu
```json
{
  "name" : "Sushi",
  "description" : "Very delicious",
  "price" : 250,
  "category" : "Japanese"
}
```

### Show All Menus
> GET -> http://localhost:8092/api/restaurants/{restaurantId}/menu

### Find Menu by ID
> GET -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}

### Update Menu
> PUT -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}
```json
{
  "name" : "Sashimi",
  "description" : "Super delicious",
  "price" : 500,
  "category" : "Japanese"
}
```

### Delete Menu
> DELETE -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}

([back to top][readme-top])

## Menu Option
*Make sure to create a menu before creating a menu option*

### Create Menu Option
> POST -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}/options
```json
{
  "name" : "Cheese",
  "price" : 10,
  "category" : "Extra"
}
```

### Show All Menu Options
> GET -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}/options

### Find Menu Option by ID
> GET -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}

### Update Menu Option
> PUT -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}
```json
{
  "name" : "Miso",
  "price" : 25,
  "category" : "Extra"
}
```

### Delete Menu Option
> DELETE -> http://localhost:8092/api/restaurants/{restaurantId}/menu/items/{menuId}/options/{menuOptionId}

([back to top][readme-top])

<!-- Markdown Links & Images -->
[Spring.io]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io
[Spring.io/spring-boot]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[Spring-Boot-url]: https://spring.io/projects/spring-boot
[readme-top]: #ku-wongnai---restaurant-service

