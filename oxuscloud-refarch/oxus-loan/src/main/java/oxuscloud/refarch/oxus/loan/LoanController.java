package oxuscloud.refarch.oxus.loan;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "loan")
@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

	@PostMapping(consumes = "application/json")
	@Operation(summary = "Push loan data for given client scoring", responses = {
			@ApiResponse(responseCode = "202", description = "Accepted"),
			@ApiResponse(responseCode = "400", description = "Validation error") })
	public ResponseEntity<Void> loanData(@Valid @RequestBody(required = true) LoanApplicationRequest data)
			throws JsonMappingException, JsonProcessingException {
		LOGGER.info("Request data: {}", data);
		ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		LOGGER.info("Response data: {}", responseEntity);
		return responseEntity;
	}
}