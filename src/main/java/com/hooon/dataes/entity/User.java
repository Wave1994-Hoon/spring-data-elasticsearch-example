package com.hooon.dataes.entity;

import com.hooon.dataes.document.UserDocument;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 10)
  private String name;

  @Builder
  public User(String name) {
    this.name = name;
  }

  public UserDocument convertDocument() {
    return UserDocument.builder()
        .name(name)
        .build();
  }

}
