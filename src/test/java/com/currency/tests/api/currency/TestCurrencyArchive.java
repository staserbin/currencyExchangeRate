package com.currency.tests.api.currency;

import com.currency.api.CurrencyEndpoint;
import com.currency.model.ArchiveCashExchange;
import com.currency.model.ArchiveExchangeInfo;
import com.currency.tests.api.APIBaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.currency.utils.Constants.USD;
import static com.currency.utils.Logger.LOGGER;
import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertEquals;

public class TestCurrencyArchive extends APIBaseTest {

    private static final String EXTRA_URL = "/exchange_rates?json&date=";

    @Test
    public void testCurrencyArchive() throws IOException {
        LOGGER.info("GET actual currencies");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        CurrencyEndpoint currencyEndpoint = new CurrencyEndpoint();
        Response response = currencyEndpoint.getCurrency(EXTRA_URL.concat(formatter.format(currentDate)));
        assertEquals(200, response.statusCode());

        LOGGER.info("Format response body to readable list");
        String jsonString = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        ArchiveExchangeInfo rates = objectMapper.readValue(jsonString, new TypeReference<ArchiveExchangeInfo>(){});
        List<ArchiveCashExchange> ratesList = rates.getExchangeRate();

        LOGGER.info("Validate the currencies are returned");
        assertThat(ratesList.size()).isGreaterThan(1);
        assertThat(ratesList.stream().filter(s -> s.getCurrency().equals(USD)).findFirst().get()
                .getSaleRate()).isNotNull();
    }

}
