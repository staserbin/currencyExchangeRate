package com.currency.tests.api;

import com.currency.api.CurrencyEndpoint;
import com.currency.pojo.CashExchange;
import com.currency.tests.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.currency.utils.Constants.*;
import static org.testng.Assert.assertEquals;

public class TestCurrency extends BaseTest {

    private static final String EXTRA_URL = "/pubinfo?exchange&coursid=5";

    @Test
    public void getRequest() throws IOException {
        LOGGER.info("GET actual currencies");
        CurrencyEndpoint currencyEndpoint = new CurrencyEndpoint(EXTRA_URL);
        Response response = currencyEndpoint.getCurrency();
        assertEquals(200, response.statusCode());

        LOGGER.info("Format response body to readable list");
        String jsonString = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CashExchange> rateList = objectMapper.readValue(jsonString, new TypeReference<>(){});
//        CashExchange[] cash = objectMapper.readValue(jsonString, CashExchange[].class);
//        List<CashExchange> rateList = new ArrayList(Arrays.asList(cash));

        LOGGER.info("Validate the currencies are returned");
        validateCurrencies(rateList, 0, EUR);
        validateCurrencies(rateList, 1, USD);
    }

    private void validateCurrencies(List<CashExchange> rates, Integer index, String currency) {
        Assert.assertTrue(rates.get(index).getCcy().contains(currency));
        Assert.assertNotEquals(rates.get(index).getBuy(), rates.get(index).getSale());
    }
}
