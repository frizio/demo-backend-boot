package dev.frizio.web.demo.converters;

import org.springframework.stereotype.Component;

import dev.frizio.web.demo.dtos.UserDTO;
import dev.frizio.web.demo.entities.User;

@Component
public class UserConverter {


    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getSurname() + " " + user.getName(), user.getAddress());
    }

    public User userDTOToUser(UserDTO userDTO) {
        String[] surnameAndName = userDTO.getName().split(" ");
        return new User(surnameAndName[1], surnameAndName[0], userDTO.getAddress());
    }
}
