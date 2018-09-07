package pl.rzonsol.microservices.currencyexchangeservice.contraoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger LOG = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        LOG.info("Conversion from: "+ from + " to: "+ to);
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to).orElseThrow(()-> new ConversionNotFoundException("Conversion from: "+ from + " to: "+ to + " not found in DB" ));

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
