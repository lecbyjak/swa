package cvut.fel.swa.fas.service;

import cvut.fel.swa.fas.model.OxusAppDataDTO;
import cvut.fel.swa.fas.model.ScoringResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoringResultService {

    @Autowired
    private OxusLoanAppClient oxusLoanAppClient;

    @KafkaListener(
            topics = {"${fas.kafka.topic.scoringresult}"},
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void processMessage(ScoringResultDTO scoringResultDTO) {
        log.info("> processMessage - {}", scoringResultDTO);
        OxusAppDataDTO oxusAppDataDTO = new OxusAppDataDTO(scoringResultDTO);
        oxusLoanAppClient.pushData(oxusAppDataDTO);
    }

}
