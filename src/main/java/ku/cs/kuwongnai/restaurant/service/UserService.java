package ku.cs.kuwongnai.restaurant.service;

import ku.cs.kuwongnai.restaurant.entity.User;
import ku.cs.kuwongnai.restaurant.model.UserRequest;
import ku.cs.kuwongnai.restaurant.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepository.findById(id).orElse(null);
    }

    public User update(UserRequest user) {
        User record = getById(user.getId());

        record.setName(user.getName());
        record.setEmail(user.getEmail());
        record.setEmailVerifiedAt(user.getEmailVerifiedAt());

        return userRepository.save(record);
    }
}
