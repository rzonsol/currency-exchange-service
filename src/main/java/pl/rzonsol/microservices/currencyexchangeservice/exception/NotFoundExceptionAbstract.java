package pl.rzonsol.microservices.currencyexchangeservice.exception;

abstract class NotFoundExceptionAbstract extends RuntimeException{
    public NotFoundExceptionAbstract(String message) {
        super(message);
    }
}
