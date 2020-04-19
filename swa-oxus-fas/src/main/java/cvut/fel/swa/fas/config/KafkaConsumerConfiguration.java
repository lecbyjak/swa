package cvut.fel.swa.fas.config;

import cvut.fel.swa.fas.model.ScoringResultDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.*;

@Configuration
class KafkaConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${fas.kafka.topic.scoringresult}")
    private String scoringResultTopic;

    @Bean
    public Map<String, Object> consumerConfigs() {
        HashMap<String, Object> props = new HashMap();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, new StringDeserializer());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new JsonDeserializer());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, scoringResultTopic);
        return props;
    }

    @Bean
    public ConsumerFactory<String, ScoringResultDTO> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String, ScoringResultDTO>(
                consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer(ScoringResultDTO.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ScoringResultDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ScoringResultDTO> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}