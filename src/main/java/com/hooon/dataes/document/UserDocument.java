package com.hooon.dataes.document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "user", createIndex = false)
public class UserDocument {

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String name;

}
