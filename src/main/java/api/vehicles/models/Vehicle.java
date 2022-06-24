package api.vehicles.models;

import org.springframework.data.annotation.Id;

public abstract class Vehicle {

    @Id
    private String id;
    private int anoModelo;
    private int anoFabricacao;
    private int valor;
    private String modelo;
    private String consumo;
    private String motor;

    protected Vehicle() {
    }
    protected Vehicle(String id, int anoModelo, int anoFabricacao, int valor, String modelo, String consumo, String motor) {
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
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
