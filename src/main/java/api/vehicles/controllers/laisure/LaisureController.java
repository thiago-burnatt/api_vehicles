package api.vehicles.controllers.laisure;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.services.interfaces.LaisureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/laisure")
public class LaisureController {

    @Autowired
    LaisureService laisureService;

    @PostMapping()
    public List<String> insert(@Valid LaisureDto laisureDto) {
        List<String> messages = new ArrayList<>();

        try {
            if (laisureDto.getAnoModelo() < 1990 || laisureDto.getAnoFabricacao() < 1990) {
                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
            }

            if (laisureDto.getNrPortas() < 1) {
                messages.add("Número de portas precisa ser superior a 1");
            }
            if (laisureDto.getConsumo().isBlank()) {
                messages.add("Consumo precisa ser preenchido");
            }
            if (laisureDto.getModelo().isBlank()) {
                messages.add("Modelo precisa ser preenchido");
            }
            if (laisureDto.getCorExterna().isBlank()) {
                messages.add("Cor externa precisa ser preenchido");
            }
            if (laisureDto.getCorInterna().isBlank()) {
                messages.add("Cor interna precisa ser preenchido");
            }
            if (laisureDto.getMotor().isBlank()) {
                messages.add("Motor precisa ser preenchido");
            }
            if (laisureDto.getValor() <= 0) {
                messages.add("Valor precisa ser maior que zero");
            }

            if (messages.isEmpty()) {
                messages.add("Veículo cadastrado com sucesso");

                laisureService.insert(laisureDto);
            }

            return messages;

        } catch (Exception e) {
            messages.add("Ocorreu um erro, tente novamente");
            return messages;
        }
    }


    @GetMapping
    public List<Laisure> findAll() {
        return this.laisureService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Laisure findById(@PathVariable String id) {
        return laisureService.findById(id);
    }

    @PostMapping(value = "/{id}")
    public List<String> update(@Valid @PathVariable String id, LaisureDto laisureDto) {
        List<String> messages = new ArrayList<>();

        try {
            Laisure laisure = laisureService.findById(id);

            if (laisureDto.getAnoModelo() < 1990 || laisureDto.getAnoFabricacao() < 1990) {
                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
            }
            if (laisureDto.getNrPortas() < 1) {
                messages.add("Número de portas precisa ser superior a 1");
            }
            if (laisureDto.getConsumo().isBlank()) {
                messages.add("Consumo precisa ser preenchido");
            }
            if (laisureDto.getModelo().isBlank()) {
                messages.add("Modelo precisa ser preenchido");
            }
            if (laisureDto.getCorExterna().isBlank()) {
                messages.add("Cor externa precisa ser preenchido");
            }
            if (laisureDto.getCorInterna().isBlank()) {
                messages.add("Cor interna precisa ser preenchido");
            }
            if (laisureDto.getMotor().isBlank()) {
                messages.add("Motor precisa ser preenchido");
            }
            if (laisureDto.getValor() <= 0) {
                messages.add("Valor precisa ser maior que zero");
            }

            laisure.setAnoModelo(laisureDto.getAnoModelo());
            laisure.setAnoFabricacao(laisureDto.getAnoFabricacao());
            laisure.setValor(laisureDto.getValor());
            laisure.setModelo(laisureDto.getModelo());
            laisure.setConsumo(laisureDto.getConsumo());
            laisure.setMotor(laisureDto.getMotor());
            laisure.setNrPortas(laisureDto.getNrPortas());
            laisure.setCorInterna(laisureDto.getCorInterna());
            laisure.setCorExterna(laisureDto.getCorExterna());

            if (messages.isEmpty()) {
                messages.add("Veículo alterado com sucesso");
                laisureService.save(laisure);
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
            Laisure findToDelete = laisureService.findById(id);
            laisureService.deleteById(findToDelete.getId());
            messages.add("Veículo excluído com sucesso");
            return messages;

        } catch (Exception e) {
            messages.add("Veículo não encontrado");
            return messages;
        }
    }

}
