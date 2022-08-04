package api.vehicles.controllers.cargo;

import api.vehicles.controllers.MessageHandler;
import api.vehicles.controllers.Validator;
import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import api.vehicles.services.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public List<Validator> insert(@Valid CargoDto cargoDto, BindingResult bindingResult) {
        MessageHandler messageHandler = new MessageHandler();

        if (!bindingResult.hasErrors()) {
            cargoService.insert(cargoDto);
            return messageHandler.successMessage();

        } else {
            return messageHandler.errorsMessage(bindingResult);
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
    public List<Validator> update(@PathVariable String id, @Valid CargoDto cargoDto,
                                  BindingResult bindingResult) {
        MessageHandler messageHandler = new MessageHandler();

        if (!bindingResult.hasErrors()) {
            cargoService.update(id, cargoDto);
            return messageHandler.successMessage();

        } else {
            return messageHandler.errorsMessage(bindingResult);
        }
    }

    @GetMapping(value = "delete/{id}")
    public void deleteById(@PathVariable String id) {
        cargoService.deleteById(id);
    }

//    @PostMapping(value = "/{id}")
//    public Cargo update(@Valid @PathVariable String id, CargoDto cargoDto) {
//        return cargoService.save(id, cargoDto);
//    }

    //    @PostMapping
//    public Cargo insert(@Valid CargoDto cargoDto, BindingResult bindingResult) {
//        return cargoService.insert(cargoDto);
//    }

//    @PostMapping
//    public String insert(@Valid CargoDto cargoDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "Seu formulario contem " + bindingResult.getErrorCount() +
//                    " erro(s), por favor verifique e tente novamente";
//        }
//        return cargoService.insert(cargoDto);
//    }

}
