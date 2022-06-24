package api.vehicles.services.interfaces;

import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;

import java.util.List;

public interface CargoService {

    Cargo insert(CargoDto cargoDto);
    List<Cargo> findAll();
    Cargo findById(String id);
    Cargo save(Cargo cargo);
    void deleteById(String id);
}
