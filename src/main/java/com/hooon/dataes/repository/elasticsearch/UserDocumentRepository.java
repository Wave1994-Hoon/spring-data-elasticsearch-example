package com.hooon.dataes.repository.elasticsearch;

import com.hooon.dataes.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDocumentRepository extends
    ElasticsearchRepository<UserDocument, String>,
    BaseElasticSearchRepository<UserDocument> {

  List<UserDocument> findUserDocumentByName(String name);
}
