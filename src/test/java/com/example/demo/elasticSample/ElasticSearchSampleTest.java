package com.example.demo.elasticSample;

import com.example.demo.elasticSample.config.ElasticTestContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Import(ElasticTestContainer.class)
@SpringBootTest(classes = ElasticSampleSearchRepository.class)
public class ElasticSearchSampleTest {

    @Autowired
    ElasticSampleSearchRepository elasticSampleSearchRepository;

    //@Autowired
    //private ElasticSampleRepository elasticSampleRepository;

    @DisplayName("elastic search Document 테스트")
    @Test
    public void test () {
        List<ElasticSample> elasticSampleList = new ArrayList<>();
        elasticSampleList.add(new ElasticSample("gogo"));
        elasticSampleList.add(new ElasticSample("go"));
        elasticSampleList.add(new ElasticSample("gogogo"));
        //elasticSampleRepository.saveAll(elasticSampleList);
    }

    @DisplayName("불러와 확마!")
    @Test
    public void test2 () {
        ElasticSampleDocument elasticSampleDocument =
                ElasticSampleDocument.from(new ElasticSample(1L, "gogo"));
        elasticSampleSearchRepository.save(elasticSampleDocument);

        Optional<ElasticSampleDocument> maybeElasticSampleDocument = elasticSampleSearchRepository.findById(1L);
        if (maybeElasticSampleDocument.isPresent()) {
            System.out.println(maybeElasticSampleDocument.get());
        }
    }
}
