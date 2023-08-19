package com.virgingames.virgingamessteps;

import com.virgingames.constants.Endpoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesInfoSteps {

    @Step("Getting all the data")
    public ValidatableResponse getAllData() {
        return SerenityRest.given()
                .when()
                .get(Endpoints.GET_ALL_DATA)
                .then();
    }

}
