package api.vehicles.controllers;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    public List<Validator> errorsMessage(BindingResult bindingResult) {
        List<Validator> messages = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(violation -> {
            Validator error = new Validator();
            String message = violation.getDefaultMessage();
            String field = violation.getField();
            error.setDefaultMessage(message);
            error.setField(field);
            messages.add(error);
        });
        return messages;
    }

    public List<Validator> successMessage() {
        List<Validator> messages = new ArrayList<>();

        Validator success = new Validator();
        success.setDefaultMessage("Operaçao realizada com sucesso!");
        success.setField("Sucesso");
        messages.add(success);
        return messages;
    }
}
