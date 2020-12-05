package dev.frizio.web.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.frizio.web.demo.converters.UserConverter;
import dev.frizio.web.demo.dtos.UserDTO;
import dev.frizio.web.demo.entities.User;
import dev.frizio.web.demo.exceptions.UserNotFoundException;
import dev.frizio.web.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    private UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return userConverter.userToUserDTO(user.get());
        }
        else {
            throw new UserNotFoundException(id);
        }
    }
}
