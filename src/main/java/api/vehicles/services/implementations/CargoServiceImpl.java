package api.vehicles.services.implementations;

import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import api.vehicles.repositories.CargoRepository;
import api.vehicles.services.interfaces.CargoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public void insert(CargoDto cargoDto) {
        Cargo cargo = new Cargo();
        BeanUtils.copyProperties(cargoDto, cargo);
        cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo findById(String id) {
        return cargoRepository.findById(id).get();
    }

    @Override
    public void update(String id, CargoDto cargoDto) {
        Cargo cargo = cargoRepository.findById(id).get();
        BeanUtils.copyProperties(cargoDto, cargo);
        cargoRepository.save(cargo);
    }

//    @Override
//    public Cargo insert(CargoDto cargoDto) {
//        Cargo cargo = new Cargo();
//        BeanUtils.copyProperties(cargoDto, cargo);
//        return cargoRepository.save(cargo);

//        List<String> messages = new ArrayList<>();
//
//        try {
//            if (cargoDto.getAnoModelo() < 1990 || cargoDto.getAnoFabricacao() < 1990) {
//                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
//            }
//
//            if (cargoDto.getCargaMax() <= 0) {
//                messages.add("Carga máxima precisa ser maior que 0");
//            }
//            if (cargoDto.getConsumo().isBlank()) {
//                messages.add("Consumo precisa ser preenchido");
//            }
//            if (cargoDto.getModelo().isBlank()) {
//                messages.add("Modelo precisa ser preenchido");
//            }
//            if (cargoDto.getAltura() <= 0) {
//                messages.add("Altura precisa ser maior que 0");
//            }
//            if (cargoDto.getComprimento() <= 0) {
//                messages.add("Comprimento precisa ser maior que 0");
//            }
//            if (cargoDto.getLargura() <= 0) {
//                messages.add("Largura precisa ser maior que 0");
//            }
//            if (cargoDto.getMotor().isBlank()) {
//                messages.add("Motor precisa ser preenchido");
//            }
//            if (cargoDto.getValor() <= 0) {
//                messages.add("Valor precisa ser maior que zero");
//            }
//
//            if (messages.isEmpty()) {
//                messages.add("Veículo cadastrado com sucesso");
//
//                Cargo cargo = new Cargo();
//                BeanUtils.copyProperties(cargoDto, cargo);
//                cargoRepository.save(cargo);
//            }
//
//            return messages;
//
//        } catch (Exception e) {
//            messages.add("Ocorreu um erro, tente novamente");
//            return messages;
//        }


//    @Override
//    public Cargo save(String id, CargoDto cargoDto) {
//        Cargo cargo = cargoRepository.findById(id).get();
//        BeanUtils.copyProperties(cargoDto, cargo);
//        return cargoRepository.save(cargo);

//        List<String> messages = new ArrayList<>();
//
//        try {
//            Cargo cargo = cargoRepository.findById(id).get();
//
//            if (cargoDto.getAnoModelo() < 1990 || cargoDto.getAnoFabricacao() < 1990) {
//                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
//            }
//            if (cargoDto.getCargaMax() <= 0) {
//                messages.add("Carga máxima precisa ser maior que 0");
//            }
//            if (cargoDto.getConsumo().isBlank()) {
//                messages.add("Consumo precisa ser preenchido");
//            }
//            if (cargoDto.getModelo().isBlank()) {
//                messages.add("Modelo precisa ser preenchido");
//            }
//            if (cargoDto.getAltura() <= 0) {
//                messages.add("Altura precisa ser maior que 0");
//            }
//            if (cargoDto.getComprimento() <= 0) {
//                messages.add("Comprimento precisa ser maior que 0");
//            }
//            if (cargoDto.getLargura() <= 0) {
//                messages.add("Largura precisa ser maior que 0");
//            }
//            if (cargoDto.getMotor().isBlank()) {
//                messages.add("Motor precisa ser preenchido");
//            }
//            if (cargoDto.getValor() <= 0) {
//                messages.add("Valor precisa ser maior que zero");
//            }
//
//            if (messages.isEmpty()) {
//                messages.add("Veículo "+ "**"+cargoDto.getModelo() + "**" + " com sucesso");
//                BeanUtils.copyProperties(cargoDto, cargo);
//                cargoRepository.save(cargo);
//            }
//
//        } catch (Exception e) {
//            messages.add("Veículo não encontrado");
//            return messages;
//        }
//        return messages;
//
//        return cargo;
//    }

    @Override
    public void deleteById(String id){
        cargoRepository.deleteById(id);
    }
}
