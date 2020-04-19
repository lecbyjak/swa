package oxuscloud.refarch.oxus.crm;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Client data")
public class ClientData {
	@Schema(required = true, description= "Unique client identifier")
	private long id;
	
	@Schema(required = true, description = "Client name")
	private String name;
	
	@Schema(required = true, description = "Client monthly income")
	private int income;
	
	@Schema(required = true, description = "Client monthly expense")
	private int expense;

	public ClientData() {
		super();
	}

	public ClientData(long id, String name, int income, int expense) {
		super();
		this.id = id;
		this.name = name;
		this.income = income;
		this.expense = expense;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "ClientData [id=" + id + ", name=" + name + ", income=" + income + ", expense=" + expense + "]";
	}
	
	

}
