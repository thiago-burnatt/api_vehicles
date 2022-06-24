package api.vehicles.dtos;

import javax.validation.constraints.NotNull;

public class LaisureDto extends VehicleDto{

    @NotNull
    private int nrPortas;

    @NotNull
    private String corInterna;

    @NotNull
    private String corExterna;

    public int getNrPortas() {
        return nrPortas;
    }

    public void setNrPortas(int nrPortas) {
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
