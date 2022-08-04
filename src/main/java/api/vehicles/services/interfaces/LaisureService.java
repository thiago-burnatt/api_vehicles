package api.vehicles.services.interfaces;

import api.vehicles.controllers.Validator;
import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface LaisureService {

//    Laisure insert(LaisureDto laisureDto);
    void insert(LaisureDto laisureDto);

    //    Laisure save(String id, LaisureDto laisureDto);
    void update(String id, LaisureDto laisureDto);

    List<Laisure> findAll();
    Laisure findById(String id);
    void deleteById(String id);

}
