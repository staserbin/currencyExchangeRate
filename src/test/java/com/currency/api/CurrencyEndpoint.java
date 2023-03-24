package com.currency.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.currency.utils.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class CurrencyEndpoint extends BaseEndpoint{

    public CurrencyEndpoint(String baseUrl, String extraURL) {
        super(baseUrl, extraURL);
    }

    public Response getCurrency() {
        Response response = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .get("/pubinfo?exchange&coursid=5")
                .then()
                .extract().response();
        return response;
    }
}
