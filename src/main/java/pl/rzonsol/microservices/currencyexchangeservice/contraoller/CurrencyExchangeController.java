package pl.rzonsol.microservices.currencyexchangeservice.contraoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.rzonsol.microservices.currencyexchangeservice.exception.ConversionNotFoundException;
import pl.rzonsol.microservices.currencyexchangeservice.model.ExchangeValue;
import pl.rzonsol.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to).orElseThrow(()-> new ConversionNotFoundException("Conversion from: "+ from + " to: "+ to + " not found in DB" ));

        return exchangeValue;
    }
}
