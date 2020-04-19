package oxuscloud.refarch.oxus.loan;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

@Validated
@Schema(description = "Loan application with scoring result")
public class LoanApplicationRequest {

	@Min(1)
	@Schema(required = true, description= "Unique client identifier")
	private long clientId;
	
	@Min(1000)
	@NotNull
	@Schema(required = true, description = "Requested loan amount", minimum = "1000")
	private BigDecimal loanAmount;
	
	@NotNull
	@Schema(required = true, description = "Scoring result")
	private ScoringResult result;

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public ScoringResult getResult() {
		return result;
	}

	public void setResult(ScoringResult result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LoanApplicationRequest [clientId=" + clientId + ", loanAmount=" + loanAmount + ", result=" + result
				+ "]";
	}
	
	
}
