package com.currency.tests.api.currency;

import com.currency.model.CashExchange;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.currency.utils.Constants.*;
import static com.currency.utils.Logger.LOGGER;
import static org.testng.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class TestCurrencyActual extends APIBaseTest {

    private static final String EXTRA_URL = "/pubinfo?exchange&coursid=5";

    @Test
    public void testCurrencyActual() throws IOException {
        LOGGER.info("GET actual currencies");
        Response response = currencyEndpoint.getCurrency(EXTRA_URL);
        assertEquals(200, response.statusCode());

        LOGGER.info("Format response body to readable list");
        String jsonString = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CashExchange> rateList = objectMapper.readValue(jsonString, new TypeReference<>(){});

        LOGGER.info("Validate that currencies are returned");
        validateCurrencies(rateList, USD);
        validateCurrencies(rateList, EUR);
    }

    private void validateCurrencies(List<CashExchange> rateList, String currency) {
        assertThat(rateList.stream().filter(s -> s.getCcy().equals(currency)).findFirst()).isPresent();
        assertThat(rateList.stream().filter(s -> s.getCcy().equals(currency)).findFirst().get().getSale()).isNotNull();
    }
}
