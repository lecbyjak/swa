package cvut.fel.swa.risc.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OxusClientDataDTO {
    private int id;
    private String name;
    private double income;
    private double expense;
}
