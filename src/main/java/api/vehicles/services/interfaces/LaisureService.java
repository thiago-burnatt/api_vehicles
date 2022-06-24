package api.vehicles.services.interfaces;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;

import java.util.List;

public interface LaisureService {

    List<Laisure> findAll();
    Laisure findById(String id);
    Laisure insert(LaisureDto laisureDto);

    Laisure save(Laisure laisure);
    void deleteById(String id);
}
