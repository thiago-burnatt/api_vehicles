package api.vehicles.services.implementations;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.repositories.LaisureRepository;
import api.vehicles.services.interfaces.LaisureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaisureServiceImpl implements LaisureService {
    @Autowired
    LaisureRepository laisureRepository;

    @Override
    public Laisure insert(LaisureDto laisureDto) {
        Laisure laisure = new Laisure();

        laisure.setId(laisureDto.getId());
        laisure.setCorExterna(laisureDto.getCorExterna());
        laisure.setCorInterna(laisureDto.getCorInterna());
        laisure.setNrPortas(laisureDto.getNrPortas());
        laisure.setConsumo(laisureDto.getConsumo());
        laisure.setAnoFabricacao(laisureDto.getAnoFabricacao());
        laisure.setAnoModelo(laisureDto.getAnoModelo());
        laisure.setModelo(laisureDto.getModelo());
        laisure.setMotor(laisureDto.getMotor());
        laisure.setValor(laisureDto.getValor());

        return laisureRepository.save(laisure);
    }

    @Override
    public Laisure save(Laisure laisure) {
        return laisureRepository.save(laisure);
    }

    @Override
    public List<Laisure> findAll() {
        return laisureRepository.findAll();
    }

    @Override
    public Laisure findById(String id) {
            return laisureRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        laisureRepository.deleteById(id);
    }

}
