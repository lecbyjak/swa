package oxuscloud.refarch.oxus.crm;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "client")
@RestController
@RequestMapping("/api/v1/client")
public class ClientInfoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientInfoController.class);

	private Map<Long, ClientData> clientModel;

	{
		clientModel = new HashMap<>();
		clientModel.put(1L, new ClientData(1L, "Frank Enstein", 100000, 10000));
		clientModel.put(2L, new ClientData(2L, "Jennifer Henderson", 10000, 50000));
		clientModel.put(3L, new ClientData(3L, "Ines Gonzales", 32855, 7500));
		clientModel.put(4L, new ClientData(4L, "Bruce Mcdonald", 22100, 13000));
		clientModel.put(5L, new ClientData(5L, "Amber Adams", 50000, 10000));
	}
	
	public ClientInfoController() {
		super();
		LOGGER.info("Mock data: {}", clientModel);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get client data for client id", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "Client id not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }, parameters = {
					@Parameter(name = "id", description = "Unique client id") })
	public ResponseEntity<GetClientDataResponse> getClientData(@PathVariable("id") long id)
			throws JsonMappingException, JsonProcessingException {
		LOGGER.info("Request data: client id {}", id);
		ClientData client = clientModel.get(id);
		if (client == null) {
			ResponseEntity<GetClientDataResponse> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			LOGGER.info("Response data: {}", responseEntity);
			return responseEntity;
		}

		ResponseEntity<GetClientDataResponse> responseEntity = new ResponseEntity<GetClientDataResponse>(new GetClientDataResponse(client), HttpStatus.OK);
		LOGGER.info("Response data: {}", responseEntity);
		return responseEntity;
	}
}