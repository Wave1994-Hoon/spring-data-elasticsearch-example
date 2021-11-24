package com.hooon.dataes.service;

import com.hooon.dataes.config.ModelMapperConfig;
import com.hooon.dataes.document.UserDocument;
import com.hooon.dataes.entity.User;
import com.hooon.dataes.repository.elasticsearch.UserDocumentRepository;
import com.hooon.dataes.repository.jpa.UserRepository;
import com.hooon.dataes.util.IndexUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserIndexingService {

  private final UserRepository userRepository;
  private final UserDocumentRepository userDocumentRepository;
  private final ModelMapper modelMapper;

  private static final String INDEX_PREFIX_NAME ="user";
  private static final String ALIAS_NAME = "user";

  @PostConstruct
  public void indexingUserDate() {
    IndexCoordinates indexNameWrapper = IndexUtil.createIndexNameWithPostFixWrapper(INDEX_PREFIX_NAME);
    IndexCoordinates aliasNameWrapper = IndexUtil.createIndexNameWrapper(ALIAS_NAME);

    Set<String> existIndexNames = userDocumentRepository.findIndexNamesByAlias(aliasNameWrapper);
    List<User> users = userRepository.findAll();

    List<UserDocument> userDocuments = users.stream()
        .map(user -> modelMapper.map(user, UserDocument.class))
        .collect(Collectors.toList());


    userDocumentRepository.saveAll(userDocuments, indexNameWrapper);

    existIndexNames.forEach(indexName -> userDocumentRepository.deleteIndex(IndexUtil.createIndexNameWrapper(indexName)));
    userDocumentRepository.setAlias(indexNameWrapper, aliasNameWrapper);

  }

}
