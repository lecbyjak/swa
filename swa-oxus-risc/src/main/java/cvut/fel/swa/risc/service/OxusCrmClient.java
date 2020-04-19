package cvut.fel.swa.risc.service;

import cvut.fel.swa.risc.model.OxusClientDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
class OxusCrmClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${oxus.crm.url}")
    private String baseUrl;


    public OxusClientDataDTO getCustomerInfo(int id) {
        log.info("> getCustomerInfo - {}", id);

        ResponseEntity oxusResponse = restTemplate.getForEntity(baseUrl+"/api/v1/client/"+id, OxusClientDataDTO.class);

        log.info("< getCustomerInfo - {}", oxusResponse);
        return (OxusClientDataDTO) oxusResponse.getBody();
    }

}