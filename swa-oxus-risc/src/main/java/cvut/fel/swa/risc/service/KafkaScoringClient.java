package cvut.fel.swa.risc.service;

import cvut.fel.swa.risc.model.ScoringRequestDTO;
import cvut.fel.swa.risc.model.CustomerResultEnum;
import cvut.fel.swa.risc.model.ScoringResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class KafkaScoringClient {

    @Autowired
    private CustomerScoringService scoringService;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${risc.kafka.topic.scoringresult}")
    private String resultTopic;


    @KafkaListener(
            topics = {"${risc.kafka.topic.scoringrequest}"},
            containerFactory = "kafkaListenerContainerFactory")
    public void processMessage(ScoringRequestDTO scoringRequestDTO) {
        log.info("> processMessage - ", scoringRequestDTO);

        CustomerResultEnum customerResult = scoringService.scoreCustomer(scoringRequestDTO);
        ScoringResultDTO scoringResultDTO = new ScoringResultDTO(scoringRequestDTO);

        scoringResultDTO.setResult(customerResult);

        log.info("> publishResponse - {}", scoringResultDTO);

        kafkaTemplate.send(resultTopic, scoringResultDTO);
    }

}