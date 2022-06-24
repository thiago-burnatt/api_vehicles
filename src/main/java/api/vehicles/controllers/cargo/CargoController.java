package api.vehicles.controllers.cargo;

import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import api.vehicles.services.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public List<String> insert(@Valid CargoDto cargoDto) {
        List<String> messages = new ArrayList<>();

        try {
            if (cargoDto.getAnoModelo() < 1990 || cargoDto.getAnoFabricacao() < 1990) {
                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
            }

            if (cargoDto.getCargaMax() <= 0) {
                messages.add("Carga máxima precisa ser maior que 0");
            }
            if (cargoDto.getConsumo().isBlank()) {
                messages.add("Consumo precisa ser preenchido");
            }
            if (cargoDto.getModelo().isBlank()) {
                messages.add("Modelo precisa ser preenchido");
            }
            if (cargoDto.getAltura() <= 0) {
                messages.add("Altura precisa ser maior que 0");
            }
            if (cargoDto.getComprimento() <= 0) {
                messages.add("Comprimento precisa ser maior que 0");
            }
            if (cargoDto.getLargura() <= 0) {
                messages.add("Largura precisa ser maior que 0");
            }
            if (cargoDto.getMotor().isBlank()) {
                messages.add("Motor precisa ser preenchido");
            }
            if (cargoDto.getValor() <= 0) {
                messages.add("Valor precisa ser maior que zero");
            }

            if (messages.isEmpty()) {
                messages.add("Veículo cadastrado com sucesso");
                cargoService.insert(cargoDto);
            }

            return messages;

        } catch (Exception e) {
            messages.add("Ocorreu um erro, tente novamente");
            return messages;
        }

    }

    @GetMapping
    public List<Cargo> findAll() {
        return this.cargoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cargo findById(@PathVariable String id) {
        return cargoService.findById(id);
    }

    @PostMapping(value = "/{id}")
    public List<String> update(@Valid @PathVariable String id, CargoDto cargoDto) {
        List<String> messages = new ArrayList<>();

        try {
            Cargo cargo = cargoService.findById(id);

            if (cargoDto.getAnoModelo() < 1990 || cargoDto.getAnoFabricacao() < 1990) {
                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
            }
            if (cargoDto.getCargaMax() <= 0) {
                messages.add("Carga máxima precisa ser maior que 0");
            }
            if (cargoDto.getConsumo().isBlank()) {
                messages.add("Consumo precisa ser preenchido");
            }
            if (cargoDto.getModelo().isBlank()) {
                messages.add("Modelo precisa ser preenchido");
            }
            if (cargoDto.getAltura() <= 0) {
                messages.add("Altura precisa ser maior que 0");
            }
            if (cargoDto.getComprimento() <= 0) {
                messages.add("Comprimento precisa ser maior que 0");
            }
            if (cargoDto.getLargura() <= 0) {
                messages.add("Largura precisa ser maior que 0");
            }
            if (cargoDto.getMotor().isBlank()) {
                messages.add("Motor precisa ser preenchido");
            }
            if (cargoDto.getValor() <= 0) {
                messages.add("Valor precisa ser maior que zero");
            }

            cargo.setAnoModelo(cargoDto.getAnoModelo());
            cargo.setAnoFabricacao(cargoDto.getAnoFabricacao());
            cargo.setValor(cargoDto.getValor());
            cargo.setModelo(cargoDto.getModelo());
            cargo.setConsumo(cargoDto.getConsumo());
            cargo.setMotor(cargoDto.getMotor());
            cargo.setCargaMax(cargoDto.getCargaMax());
            cargo.setAltura(cargoDto.getAltura());
            cargo.setComprimento(cargoDto.getComprimento());
            cargo.setLargura(cargoDto.getLargura());

            if (messages.isEmpty()) {
                messages.add("Veículo alterado com sucesso");
                cargoService.save(cargo);
            }


        } catch (Exception e) {
            messages.add("Veículo não encontrado");
            return messages;
        }
        return messages;
    }

    @GetMapping(value = "delete/{id}")
    public List<String> deleteById(@PathVariable String id) {
        List<String> messages = new ArrayList<>();

        try {
            Cargo findToDelete = cargoService.findById(id);
            cargoService.deleteById(findToDelete.getId());
            messages.add("Veículo excluído com sucesso");
            return messages;

        } catch (Exception e) {
            messages.add("Veículo não encontrado");
            return messages;
        }
    }

}
