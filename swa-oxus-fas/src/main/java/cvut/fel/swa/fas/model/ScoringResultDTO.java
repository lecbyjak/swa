package cvut.fel.swa.fas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoringResultDTO {

    private String requestId;
    private int clientId;
    private double loanAmount;
    private String callbackUrl;
    private CustomerResultEnum result;

}
