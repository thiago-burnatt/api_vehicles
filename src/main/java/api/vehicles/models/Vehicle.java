package api.vehicles.models;

import org.springframework.data.annotation.Id;

public abstract class Vehicle {

    @Id
    private String id;
    private String modelo;
    private Integer anoModelo;
    private Integer anoFabricacao;
    private Integer valor;
    private String consumo;
    private String motor;

    protected Vehicle() {
    }
    protected Vehicle(String id, Integer anoModelo, Integer anoFabricacao, Integer valor, String modelo, String consumo, String motor) {
        this.id = id;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.valor = valor;
        this.modelo = modelo;
        this.consumo = consumo;
        this.motor = motor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
}
