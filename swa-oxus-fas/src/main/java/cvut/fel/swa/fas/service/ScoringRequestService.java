package cvut.fel.swa.fas.service;

import cvut.fel.swa.fas.model.LoanRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoringRequestService {

    @Value("${fas.kafka.topic.scoringrequest}")
    public String kafkaTopic;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void scoreCustomer(LoanRequestDTO request) {
        log.debug("> scoreCustomer - sending {}", request);
        kafkaTemplate.send(kafkaTopic, request);
    }
}
