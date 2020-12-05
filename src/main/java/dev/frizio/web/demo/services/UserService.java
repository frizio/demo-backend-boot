package dev.frizio.web.demo.services;

import dev.frizio.web.demo.dtos.UserDTO;

public interface UserService {

  public UserDTO findById(Long id);

}
