package pl.rzonsol.microservices.currencyexchangeservice.contraoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.rzonsol.microservices.currencyexchangeservice.model.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        return ExchangeValue.builder()
                .id(1L)
                .from("EUR")
                .to("PLN")
                .conversionMultiple(BigDecimal.valueOf(4.3086))
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }
}
