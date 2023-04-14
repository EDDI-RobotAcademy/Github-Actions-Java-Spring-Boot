package com.example.demo.elasticSample.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
// ES 관련 리포지토리 등록
@EnableElasticsearchRepositories(basePackageClasses = {ElasticSampleRepository.class, ElasticSampleSearchRepository.class})
public class ElasticTestContainer extends AbstractElasticsearchConfiguration {

    private static final String ELASTICSEARCH_VERSION = "7.6.2";
    private static final DockerImageName ELASTICSEARCH_IMAGE =
            DockerImageName
                    .parse("docker.elastic.co/elasticsearch/elasticsearch")
                    .withTag(ELASTICSEARCH_VERSION);
    private static final ElasticsearchContainer container;

    // testContainer 띄우기
    static {
        container = new ElasticsearchContainer(ELASTICSEARCH_IMAGE);
        container.start();
    }

    // 띄운 컨테이너로 ESCilent 재정의
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(container.getHttpHostAddress())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
