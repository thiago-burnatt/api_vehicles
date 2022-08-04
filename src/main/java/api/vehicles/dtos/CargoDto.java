package api.vehicles.dtos;

import javax.validation.constraints.NotNull;

public class CargoDto extends VehicleDto{
    @NotNull(message = "O campo precisa ser preenchido")
    private Integer cargaMax;

    @NotNull(message = "O campo precisa ser preenchido")
    private Integer largura;

    @NotNull(message = "O campo precisa ser preenchido")
    private Integer comprimento;

    @NotNull(message = "O campo precisa ser preenchido")
    private Integer altura;

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
