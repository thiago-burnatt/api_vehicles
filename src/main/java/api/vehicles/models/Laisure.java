package api.vehicles.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Laisure extends Vehicle{

    private int nrPortas;
    private String corInterna;
    private String corExterna;

    public Laisure (String id, int anoModelo, int anoFabricacao, int valor, String modelo, String consumo, String motor,
                    int nrPortas, String corExterna, String corInterna) {
        super(id, anoModelo, anoFabricacao, valor, modelo, consumo, motor);

        this.nrPortas = nrPortas;
        this.corInterna = corInterna;
        this.corExterna = corExterna;
    }

    public Laisure() {

    }

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
