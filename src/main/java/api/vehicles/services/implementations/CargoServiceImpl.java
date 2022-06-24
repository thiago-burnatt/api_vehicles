package api.vehicles.services.implementations;

import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import api.vehicles.repositories.CargoRepository;
import api.vehicles.services.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo insert(CargoDto cargoDto) {
        Cargo cargo = new Cargo();

        cargo.setId(cargoDto.getId());
        cargo.setAnoModelo(cargoDto.getAnoModelo());
        cargo.setAnoFabricacao(cargoDto.getAnoFabricacao());
        cargo.setConsumo(cargoDto.getConsumo());
        cargo.setAltura(cargoDto.getAltura());
        cargo.setMotor(cargoDto.getMotor());
        cargo.setCargaMax(cargoDto.getCargaMax());
        cargo.setComprimento(cargoDto.getComprimento());
        cargo.setLargura(cargoDto.getLargura());
        cargo.setModelo(cargoDto.getModelo());
        cargo.setValor(cargoDto.getValor());

        return cargoRepository.save(cargo);
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
    public Cargo save(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void deleteById(String id) {
        cargoRepository.deleteById(id);
    }
}
