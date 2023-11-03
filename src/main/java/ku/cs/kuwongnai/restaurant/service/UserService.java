package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.entity.User;
import ku.cs.kuwongnai.restaurant.model.UserRequest;
import ku.cs.kuwongnai.restaurant.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User create(UserRequest user) {
        User record = modelMapper.map(user, User.class);
        return userRepository.save(record);
    }

    public User getById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with the given id not found.");
        }

        return user;
    }

    public User update(UserRequest user) {
        User record = getById(user.getId());

        record.setName(user.getName());
        record.setEmail(user.getEmail());
        record.setEmailVerifiedAt(user.getEmailVerifiedAt());

        return userRepository.save(record);
    }
}
