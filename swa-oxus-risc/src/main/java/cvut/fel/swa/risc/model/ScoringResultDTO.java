package cvut.fel.swa.risc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoringResultDTO {
    private String requestId;
    private int clientId;
    private double loanAmount;
    private CustomerResultEnum result;
    private String callbackUrl;

    public ScoringResultDTO(String requestId, int clientId, double loanAmount, CustomerResultEnum result, String callbackUrl) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.loanAmount = loanAmount;
        this.result = result;
        this.callbackUrl = callbackUrl;
    }

    public ScoringResultDTO(ScoringRequestDTO scoringRequestDTO) {
        this.requestId = scoringRequestDTO.getRequestId();
        this.clientId = scoringRequestDTO.getClientId();
        this.loanAmount = scoringRequestDTO.getLoanAmount();
        this.callbackUrl = scoringRequestDTO.getCallbackUrl();
    }
}
