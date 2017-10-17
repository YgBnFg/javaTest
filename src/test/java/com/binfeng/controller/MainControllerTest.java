package com.binfeng.controller;

import base.IntegrationTest;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bfyang on 2017/10/17.
 */
public class MainControllerTest extends IntegrationTest {
    @Test
    public void testHome() {
        String homeResponse = given().when()
                .contentType(ContentType.ANY)
                .get("/")
                .then()
                .extract().response().body().prettyPrint();
        assertThat(homeResponse).isNotNull();
    }
}
