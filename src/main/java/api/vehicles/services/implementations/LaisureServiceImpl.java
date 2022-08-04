package api.vehicles.services.implementations;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.repositories.LaisureRepository;
import api.vehicles.services.interfaces.LaisureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaisureServiceImpl implements LaisureService {
    @Autowired
    LaisureRepository laisureRepository;

    @Override
    public void insert(LaisureDto laisureDto) {
        Laisure laisure = new Laisure();
        BeanUtils.copyProperties(laisureDto, laisure);
        laisureRepository.save(laisure);
    }


//    @Override
//    public Laisure insert(LaisureDto laisureDto) {
//        Laisure laisure = new Laisure();
//        BeanUtils.copyProperties(laisureDto, laisure);
//        return laisureRepository.save(laisure);

//        List<String> messages = new ArrayList<>();
//
//        try {
//
//            if (laisureDto.getAnoModelo() < 1990 || laisureDto.getAnoFabricacao() < 1990) {
//                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
//            }
//
//            if (laisureDto.getNrPortas() < 1) {
//                messages.add("Número de portas precisa ser superior a 1");
//            }
//            if (laisureDto.getConsumo().isBlank()) {
//                messages.add("Consumo precisa ser preenchido");
//            }
//            if (laisureDto.getModelo().isBlank()) {
//                messages.add("Modelo precisa ser preenchido");
//            }
//            if (laisureDto.getCorExterna().isBlank()) {
//                messages.add("Cor externa precisa ser preenchido");
//            }
//            if (laisureDto.getCorInterna().isBlank()) {
//                messages.add("Cor interna precisa ser preenchido");
//            }
//            if (laisureDto.getMotor().isBlank()) {
//                messages.add("Motor precisa ser preenchido");
//            }
//            if (laisureDto.getValor() <= 0) {
//                messages.add("Valor precisa ser maior que zero");
//            }
//
//            if (messages.isEmpty()) {
//                messages.add("Veículo cadastrado com sucesso");
//
//                Laisure laisure = new Laisure();
//                BeanUtils.copyProperties(laisureDto, laisure);
//                laisureRepository.save(laisure);
//            }
//
//            return messages;
//
//        } catch (Exception e) {
//            messages.add("Ocorreu um erro, tente novamente");
//            return messages;
//        }
//    }

    @Override
    public void update(String id, LaisureDto laisureDto) {
        Laisure laisure = laisureRepository.findById(id).get();
        BeanUtils.copyProperties(laisureDto, laisure);
        laisureRepository.save(laisure);
    }


//    @Override
//    public Laisure save(String id, LaisureDto laisureDto) {
//        Laisure laisure = laisureRepository.findById(id).get();
//        BeanUtils.copyProperties(laisureDto, laisure);
//        return laisureRepository.save(laisure);

//        List<String> messages = new ArrayList<>();
//
//        try {
//            Laisure laisure = laisureRepository.findById(id).get();
//
//            if (laisureDto.getAnoModelo() < 1990 || laisureDto.getAnoFabricacao() < 1990) {
//                messages.add("O ano do veículo/fabricação não pode ser inferior a 1990");
//            }
//
//            if (laisureDto.getNrPortas() < 1) {
//                messages.add("Número de portas precisa ser superior a 1");
//            }
//            if (laisureDto.getConsumo().isBlank()) {
//                messages.add("Consumo precisa ser preenchido");
//            }
//            if (laisureDto.getModelo().isBlank()) {
//                messages.add("Modelo precisa ser preenchido");
//            }
//            if (laisureDto.getCorExterna().isBlank()) {
//                messages.add("Cor externa precisa ser preenchido");
//            }
//            if (laisureDto.getCorInterna().isBlank()) {
//                messages.add("Cor interna precisa ser preenchido");
//            }
//            if (laisureDto.getMotor().isBlank()) {
//                messages.add("Motor precisa ser preenchido");
//            }
//            if (laisureDto.getValor() <= 0) {
//                messages.add("Valor precisa ser maior que zero");
//            }
//
//            if (messages.isEmpty()) {
//                messages.add("Veículo " + "**" + laisure.getModelo() + "**" + " alterado com sucesso");
//
//                BeanUtils.copyProperties(laisureDto, laisure);
//                laisureRepository.save(laisure);
//            }
//
//            return messages;
//
//        } catch (Exception e) {
//            messages.add("Ocorreu um erro, tente novamente");
//            return messages;
//        }

//    }

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
