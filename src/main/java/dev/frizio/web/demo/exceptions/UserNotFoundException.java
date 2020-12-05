package dev.frizio.web.demo.exceptions;

public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -5645891688561869158L;

  public UserNotFoundException(Long id) {
      super("User with id " + id + " not found!");
  }
}