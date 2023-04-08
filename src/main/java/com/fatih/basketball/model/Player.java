package com.fatih.basketball.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
//@SuperBuilder We can use builder pattern if we have much more property in the class in future
public class Player extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "position")
  @Enumerated(EnumType.STRING)
  private Position position;

  public Player(String name, String surname, Position position) {
    this.name = name;
    this.surname = surname;
    this.position = position;
  }

  public Player(Long id, String name, String surname, Position position) {
    super(id);
    this.name = name;
    this.surname = surname;
    this.position = position;
  }

}
