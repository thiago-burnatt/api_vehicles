package api.vehicles.controllers.laisure;

import api.vehicles.controllers.MessageHandler;
import api.vehicles.controllers.Validator;
import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.services.interfaces.LaisureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

    @PostMapping
    public List<Validator> insert(@Valid LaisureDto laisureDto, BindingResult bindingResult) {
        MessageHandler messageHandler = new MessageHandler();

        if (!bindingResult.hasErrors()) {
            laisureService.insert(laisureDto);
            return messageHandler.successMessage();

        } else {
            return messageHandler.errorsMessage(bindingResult);
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
    public List<Validator> update(@PathVariable String id, @Valid LaisureDto laisureDto, BindingResult bindingResult) {
        MessageHandler messageHandler = new MessageHandler();

        if (!bindingResult.hasErrors()) {
            laisureService.update(id, laisureDto);
            return messageHandler.successMessage();

        } else {
            return messageHandler.errorsMessage(bindingResult);
        }
    }

    @GetMapping(value = "delete/{id}")
    public void deleteById(@PathVariable String id) {
        laisureService.deleteById(id);
    }


//    @PostMapping(value = "/{id}")
//    public Laisure update(@Valid @PathVariable String id, LaisureDto laisureDto) {
//        return laisureService.save(id, laisureDto);
//    }

//    @PostMapping()
//    public Laisure insert(@Valid LaisureDto laisureDto) {
//        return laisureService.insert(laisureDto);
//    }

}
