package api.vehicles.services.interfaces;

import api.vehicles.controllers.Validator;
import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface CargoService {

//    Cargo insert(CargoDto cargoDto);
    void insert(CargoDto cargoDto);
    List<Cargo> findAll();
    Cargo findById(String id);
//    Cargo save(String id, CargoDto cargoDto);
    void update(String id, CargoDto cargoDto);
    void deleteById(String id);
}
