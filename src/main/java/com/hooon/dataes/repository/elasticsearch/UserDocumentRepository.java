package com.hooon.dataes.repository.elasticsearch;

import com.hooon.dataes.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDocumentRepository extends
    ElasticsearchRepository<UserDocument, String>,
    BaseElasticSearchRepository<UserDocument> {
}
