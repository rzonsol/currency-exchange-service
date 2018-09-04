package pl.rzonsol.microservices.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConversionNotFoundException extends NotFoundExceptionAbstract {

    public ConversionNotFoundException(String message) {
        super(message);
    }
}
