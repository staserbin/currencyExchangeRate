package com.currency.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.currency.config.ConfigurationManager.getAPIUrl;
import static io.restassured.RestAssured.given;

public class CurrencyEndpoint extends BaseEndpoint{

    public CurrencyEndpoint() {
        super();
    }

    public Response getCurrency(String extraURL) {
        Response response = given()
                .contentType(ContentType.JSON)
                .baseUri(getAPIUrl())
                .when()
                .get(extraURL)
                .then()
                .extract().response();
        return response;
    }
}
