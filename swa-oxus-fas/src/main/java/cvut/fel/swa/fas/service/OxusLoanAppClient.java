package cvut.fel.swa.fas.service;

import cvut.fel.swa.fas.model.OxusAppDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class OxusLoanAppClient {

    @Value("${oxus.loan.app.url}")
    private String oxusAppUrl;

    @Autowired
    private RestTemplate restTemplate;


    public void pushData(OxusAppDataDTO data) {
        log.info("> pushData - {}", data);
        restTemplate.postForLocation(oxusAppUrl+"/api/v1/loan", data);
       }


}
