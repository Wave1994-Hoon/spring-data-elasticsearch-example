package com.hooon.dataes.document;

import lombok.Builder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.persistence.Id;

@Builder
@Document(indexName = "user", createIndex = false)
public class UserDocument {

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String name;

}
