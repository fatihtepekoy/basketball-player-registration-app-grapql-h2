package com.fatih.basketball.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@ToString
@Builder
@Getter
@NoArgsConstructor
public class Player extends BaseEntity {

  @Column(name = "name")
  @NonNull
  private String name;

  @Column(name = "surname")
  @NonNull
  private String surname;

  @Column(name = "position")
  @Enumerated(EnumType.STRING)
  @NonNull
  private Position position;

  public Player(Long id, String name, String surname, Position position) {
    super(id);
    this.name = name;
    this.surname = surname;
    this.position = position;
  }

  public Player(String name, String surname, Position position) {
    this.name = name;
    this.surname = surname;
    this.position = position;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Player player = (Player) o;
    return getId() != null && Objects.equals(getId(), player.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
