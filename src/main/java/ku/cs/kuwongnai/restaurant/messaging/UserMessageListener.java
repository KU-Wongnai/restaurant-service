package ku.cs.kuwongnai.restaurant.messaging;

import ku.cs.kuwongnai.restaurant.model.UserRequest;
import ku.cs.kuwongnai.restaurant.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMessageListener {
    @Autowired
    private UserService userService;

    @RabbitListener(queues = "#{userCreatedQueue.name}")
    public void handleUserCreatedMessage(UserRequest user) {
        // Handle user created
        userService.create(user);
        System.out.println("From User Service: User has been created");

    }

    @RabbitListener(queues = "#{userUpdatedQueue.name}")
    public void handleUserUpdatedMessage(UserRequest user) {
        // Handle user updated message
        userService.update(user);
        System.out.println("From User Service: User has been updated");
    }
}
