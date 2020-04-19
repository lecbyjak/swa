package cvut.fel.swa.fas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanRequestDTO {

    private String requestId;
    private int clientId;
    private double loanAmount;
    private String callbackUrl;

    public LoanRequestDTO(String requestId, int clientId, double loanAmount, String callbackUrl) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.loanAmount = loanAmount;
        this.callbackUrl = callbackUrl;
    }

    public LoanRequestDTO(int clientId, double loanAmount, String callbackUrl) {
        this.clientId = clientId;
        this.loanAmount = loanAmount;
        this.callbackUrl = callbackUrl;
        this.requestId = null;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
