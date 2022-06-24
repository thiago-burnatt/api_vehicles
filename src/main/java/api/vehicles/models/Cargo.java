package api.vehicles.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cargo extends Vehicle {

    private int cargaMax;
    private int largura;
    private int comprimento;
    private int altura;

    public Cargo(String id, int anoModelo, int anoFabricacao, int valor, String modelo, String consumo, String motor, int cargaMax,
                 int largura, int comprimento, int altura) {

        super(id, anoModelo, anoFabricacao, valor, modelo, consumo, motor);

        this.cargaMax = cargaMax;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;

    }

    public Cargo() {

    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
