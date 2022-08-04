package api.vehicles.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class VehicleDto {

//    private String id;

    @NotBlank(message = "O campo precisa ser preenchido")
    private String modelo;
    @NotNull(message = "O campo precisa ser preenchido")
    @Min(value = 1990, message = "O ano do modelo nao pode ser inferior a 1990")
    private Integer anoModelo;

    @NotNull(message = "O campo precisa ser preenchido")
    @Min(value = 1990, message = "O ano de fabricaçao nao pode ser inferior a 1990")
    private Integer anoFabricacao;

    @NotNull(message = "O campo precisa ser preenchido")
    @Min(value = 1, message = "Valor precisa ser superior a zero")
    private Integer valor;

    @NotBlank(message = "O campo precisa ser preenchido")
    private String consumo;

    @NotBlank(message = "O campo precisa ser preenchido")
    private String motor;

//    public String getId() {
//        return id;
//    }

//    public void setId(String id) {
//        this.id = id;
//    }

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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
