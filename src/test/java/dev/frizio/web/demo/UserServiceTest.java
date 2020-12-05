package dev.frizio.web.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.frizio.web.demo.converters.UserConverter;
import dev.frizio.web.demo.dtos.UserDTO;
import dev.frizio.web.demo.entities.User;
import dev.frizio.web.demo.exceptions.UserNotFoundException;
import dev.frizio.web.demo.repositories.UserRepository;
import dev.frizio.web.demo.services.UserService;
import dev.frizio.web.demo.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserConverter userConverter;

    private UserService userService;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository, userConverter);
    }

    @Test
    public void findByIdSuccess() {
        User user = new User("Vincenzo", "Racca", "via Roma");
        user.setId(1L);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        UserDTO userDTO = userService.findById(1L);

        verify(userRepository, times(1)).findById(anyLong());
        
        assertNotNull(userDTO);
        String[] surnameAndName = userDTO.getName().split( " ");
        assertEquals(2, surnameAndName.length);
        assertEquals(user.getSurname(), surnameAndName[0]);
        assertEquals(user.getName(), surnameAndName[1]);
        assertEquals(user.getAddress(), userDTO.getAddress());
    }

    @Test
    public void findByIdUnSuccess() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
    
        UserNotFoundException exp = assertThrows(UserNotFoundException.class, () -> userService.findById(1L));
        assertEquals("User with id 1 not found!", exp.getMessage());
    }

}
