package com.currency.tests.api;

import com.currency.api.CurrencyEndpoint;
import com.currency.pojo.CashExchange;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.currency.utils.Constants.*;

public class TestCurrency {

    private static final String EXTRA_URL = "/pubinfo?exchange&coursid=5";

    @Test
    public void getRequest() throws JsonProcessingException {
        CurrencyEndpoint currencyEndpoint = new CurrencyEndpoint(BASE_URL, EXTRA_URL);
        Response response = currencyEndpoint.getCurrency();

        String jsonString = response.getBody().asString();

        ObjectMapper objectMapper = new ObjectMapper();
//        CashExchange[] cash = objectMapper.readValue(jsonString, CashExchange[].class);
        List<CashExchange> rateList = objectMapper.readValue(jsonString, new TypeReference<>(){});

        Assert.assertEquals(200, response.statusCode());

        validateCurrencies(rateList, 0, EUR);
        validateCurrencies(rateList, 1, USD);
    }

    private void validateCurrencies(List<CashExchange> rates, Integer index, String currency) {
        Assert.assertTrue(rates.get(index).getCcy().contains(currency));
        Assert.assertNotEquals(rates.get(index).getBuy(), rates.get(index).getSale());
    }
}
