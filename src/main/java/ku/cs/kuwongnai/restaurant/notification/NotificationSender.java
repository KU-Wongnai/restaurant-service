package ku.cs.kuwongnai.restaurant.notification;


import org.springframework.stereotype.Component;

@Component
public class NotificationSender {

    RabbitMQPublisher publisher;

    String exchangeName = "events.notification"; 
    String routingKey = "email.welcome"; // specific to routing key at receiver

    // used in this service

    public void sendInAppWelcomeNewRestaurant(String userId) throws Exception{
        String type = "noti.WelcomeNewRestaurant";
        
        // Json
        String message = "{\"to\":\"" + userId + "\", \"type\":\"" + type + "\"}";
        publisher = new RabbitMQPublisher();
        publisher.declareExchange(exchangeName, "topic");
        publisher.publish(message, exchangeName, routingKey);
        publisher.close();
    }

    public void sendInAppRestaurantRejectedAccount(String userId) throws Exception{
        String type = "noti.RestaurantRejectedAccount";
        
        String message = "{\"to\":\"" + userId + "\", \"type\":\"" + type + "\"}";
        publisher = new RabbitMQPublisher();
        publisher.declareExchange(exchangeName, "topic");
        publisher.publish(message, exchangeName, routingKey);
        publisher.close();
    }

    public void sendInAppRestaurantCreateAccount(String userId) throws Exception{
        String type = "noti.RestaurantCreateAccount";
        
        String message = "{\"to\":\"" + userId + "\", \"type\":\"" + type + "\"}";
        publisher = new RabbitMQPublisher();
        publisher.declareExchange(exchangeName, "topic");
        publisher.publish(message, exchangeName, routingKey);
        publisher.close();
    }




}
