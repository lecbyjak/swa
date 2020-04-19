package oxuscloud.refarch.oxus.crm;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Get client data response")
public class GetClientDataResponse {

	@Schema(required = true)
	private ClientData clientData;
	
	public GetClientDataResponse() {
		//default
	}

	public GetClientDataResponse(ClientData client) {
		this.clientData = client;
	}

	public ClientData getClientData() {
		return clientData;
	}

	public void setClientData(ClientData clientData) {
		this.clientData = clientData;
	}

	@Override
	public String toString() {
		return "GetClientDataResponse [clientData=" + clientData + "]";
	}
	
	
}
