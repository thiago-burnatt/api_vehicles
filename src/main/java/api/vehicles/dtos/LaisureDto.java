package api.vehicles.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LaisureDto extends VehicleDto{

    @NotNull(message = "O campo precisa ser preenchido")
    @Min(value = 1, message = "O numero de portas nao pode ser inferior a 1")
    private Integer nrPortas;

    @NotBlank(message = "O campo precisa ser preenchido")
    private String corInterna;

    @NotBlank(message = "O campo precisa ser preenchido")
    private String corExterna;

    public Integer getNrPortas() {
        return nrPortas;
    }

    public void setNrPortas(Integer nrPortas) {
        this.nrPortas = nrPortas;
    }

    public String getCorInterna() {
        return corInterna;
    }

    public void setCorInterna(String corInterna) {
        this.corInterna = corInterna;
    }

    public String getCorExterna() {
        return corExterna;
    }

    public void setCorExterna(String corExterna) {
        this.corExterna = corExterna;
    }
}
