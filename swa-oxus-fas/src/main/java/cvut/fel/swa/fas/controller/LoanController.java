package cvut.fel.swa.fas.controller;

import cvut.fel.swa.fas.model.LoanRequestDTO;
import cvut.fel.swa.fas.service.ScoringRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
class LoanController{

    @Autowired
    private ScoringRequestService scoringService;


    @PostMapping(path="/loan/request")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity requestLoan(@RequestBody LoanRequestDTO requestDTO) {
        requestDTO.setRequestId(UUID.randomUUID().toString());
        scoringService.scoreCustomer(requestDTO);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}