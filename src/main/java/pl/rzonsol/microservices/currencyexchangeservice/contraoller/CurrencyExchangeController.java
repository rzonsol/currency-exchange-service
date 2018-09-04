package pl.rzonsol.microservices.currencyexchangeservice.contraoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.rzonsol.microservices.currencyexchangeservice.model.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        return ExchangeValue.builder()
                .id(1L)
                .from("EUR")
                .to("PLN")
                .conversionMultiple(BigDecimal.valueOf(4.3086))
                .build();
    }
}
