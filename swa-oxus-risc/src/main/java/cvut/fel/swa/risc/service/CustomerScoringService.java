package cvut.fel.swa.risc.service;

import cvut.fel.swa.risc.model.OxusClientDataDTO;
import cvut.fel.swa.risc.model.ScoringRequestDTO;
import cvut.fel.swa.risc.model.CustomerResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class CustomerScoringService {

    @Autowired
    private OxusCrmClient oxusCrmClient;


    public CustomerResultEnum scoreCustomer(ScoringRequestDTO scoringRequestDTO) {
        log.info("> scoreCustomer - {}", scoringRequestDTO);

        OxusClientDataDTO clientData = oxusCrmClient.getCustomerInfo(scoringRequestDTO.getClientId());

        if (clientData == null){
            throw new RuntimeException("Failed to find client by id - "+scoringRequestDTO.getClientId());
        }

        if ((clientData.getIncome() - clientData.getExpense()) * 60 > scoringRequestDTO.getLoanAmount()) {
            return CustomerResultEnum.OK;
        } else {
            return CustomerResultEnum.NOT_OK;
        }
    }

}