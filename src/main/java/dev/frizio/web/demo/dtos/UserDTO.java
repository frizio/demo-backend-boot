package dev.frizio.web.demo.dtos;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class UserDTO {

  private String name;

  private String address;

}
