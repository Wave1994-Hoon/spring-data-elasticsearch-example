package com.hooon.dataes.entity;

import com.hooon.dataes.document.UserDocument;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter @Getter @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 10)
  private String name;

  public UserDocument convertDocument() {
    return UserDocument.builder()
        .name(name)
        .build();
  }

}
