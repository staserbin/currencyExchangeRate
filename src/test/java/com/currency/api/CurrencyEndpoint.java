package com.currency.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static com.currency.config.ConfigurationManager.getUrl;
import static io.restassured.RestAssured.given;

public class CurrencyEndpoint extends BaseEndpoint{

    public CurrencyEndpoint(String extraURL) {
        super(extraURL);
    }

    public Response getCurrency() throws IOException {
        Response response = given()
                .contentType(ContentType.JSON)
                .baseUri(getUrl())
                .when()
                .get("/pubinfo?exchange&coursid=5")
                .then()
                .extract().response();
        return response;
    }
}
