package api.vehicles.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Laisure extends Vehicle{

    private Integer nrPortas;
    private String corInterna;
    private String corExterna;

    public Laisure (String id, Integer anoModelo, Integer anoFabricacao, Integer valor, String modelo, String consumo, String motor,
                    Integer nrPortas, String corExterna, String corInterna) {
        super(id, anoModelo, anoFabricacao, valor, modelo, consumo, motor);

        this.nrPortas = nrPortas;
        this.corInterna = corInterna;
        this.corExterna = corExterna;
    }

    public Laisure() {

    }

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
