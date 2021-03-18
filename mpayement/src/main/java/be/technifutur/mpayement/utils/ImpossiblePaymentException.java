package be.technifutur.mpayement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossiblePaymentException extends Exception {
    public ImpossiblePaymentException(String message) {
        super(message);
    }
}
