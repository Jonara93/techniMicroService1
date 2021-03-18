package be.technifutur.mpayement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingPaymentException extends Exception {
    public ExistingPaymentException(String message) {
        super(message);
    }
}
