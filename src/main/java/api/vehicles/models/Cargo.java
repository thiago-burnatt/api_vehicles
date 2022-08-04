package api.vehicles.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cargo extends Vehicle {

    private Integer cargaMax;
    private Integer largura;
    private Integer comprimento;
    private Integer altura;

    public Cargo(String id, Integer anoModelo, Integer anoFabricacao, Integer valor, String modelo, String consumo, String motor, Integer cargaMax,
                 Integer largura, Integer comprimento, Integer altura) {

        super(id, anoModelo, anoFabricacao, valor, modelo, consumo, motor);

        this.cargaMax = cargaMax;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;

    }

    public Cargo() {

    }

    public Integer getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(Integer cargaMax) {
        this.cargaMax = cargaMax;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }
}
