package cvut.fel.swa.fas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OxusAppDataDTO {

    private int clientId;
    private double loanAmount;
    private String result;

    public OxusAppDataDTO(int clientId, double loanAmount, String result) {
        this.clientId = clientId;
        this.loanAmount = loanAmount;
        this.result = result;
    }

    public OxusAppDataDTO(ScoringResultDTO scoringResultDTO) {
        this.clientId = scoringResultDTO.getClientId();
        this.loanAmount = scoringResultDTO.getLoanAmount();
        this.result = scoringResultDTO.getResult().toString();
    }
}
