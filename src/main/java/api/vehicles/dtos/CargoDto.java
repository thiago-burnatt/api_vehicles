package api.vehicles.dtos;

import javax.validation.constraints.NotNull;

public class CargoDto extends VehicleDto{

    @NotNull
    private int cargaMax;

    @NotNull
    private int largura;

    @NotNull
    private int comprimento;

    @NotNull
    private int altura;

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
