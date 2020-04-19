package cvut.fel.swa.risc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoringRequestDTO {

    private String requestId;
    private int clientId;
    private double loanAmount;
    private String callbackUrl;


}
