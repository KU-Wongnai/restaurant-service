package ku.cs.kuwongnai.restaurant.publisher;

import ku.cs.kuwongnai.restaurant.entity.Restaurant;
import ku.cs.kuwongnai.restaurant.model.MenuPublish;
import ku.cs.kuwongnai.restaurant.model.RestaurantRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {
    private RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishJson(String exchange, String routingKey, Restaurant restaurant) {
        System.out.println("Message sent -> " + restaurant.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, restaurant);
    }

    public void publishMenuJson(String exchange, String routingKey, MenuPublish menu) {
        // System.out.println(menu);
        rabbitTemplate.convertAndSend(exchange, routingKey, menu);
    }

    public void publishId(String exchange, String routingKey, Long id) {
        System.out.println("Message sent ID: " + id);
        rabbitTemplate.convertAndSend(exchange, routingKey, id);
    }
}
