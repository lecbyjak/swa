package cvut.fel.swa.fas.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.*;


@Configuration
class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${fas.kafka.topic.scoringrequest}")
    private String scoringRequestTopicName;

    @Bean
    public NewTopic kafkaScoringRequestTopic(){
        return TopicBuilder.name(scoringRequestTopicName)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public Map<String, Object> producerConfigs() {
        HashMap<String, Object> props = new HashMap();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, new StringSerializer());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new JsonSerializer());
        return props;
    }

    @Bean
    public ProducerFactory producerFactory(){
        return new DefaultKafkaProducerFactory(producerConfigs());
    }

    @Bean
    public KafkaTemplate kafkaTemplate(){
        return new KafkaTemplate(producerFactory());
    }

}