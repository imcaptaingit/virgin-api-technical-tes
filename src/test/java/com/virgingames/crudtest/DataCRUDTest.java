package com.virgingames.crudtest;

import com.virgingames.testbase.TestBase;
import com.virgingames.virgingamessteps.VirginGamesInfoSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)

public class DataCRUDTest extends TestBase {

    static ValidatableResponse response;

    @Steps
    VirginGamesInfoSteps virginGamesInfoSteps;

    @Title("Getting all data information")
    @Test
    public void test001() {
        ValidatableResponse response = virginGamesInfoSteps.getAllData();
        response.log().all().statusCode(200);
    }

    @Title("This method will verify jackpot Id is Roxor Progressives")
    @Test
    public void test002(){
        ValidatableResponse response = virginGamesInfoSteps.getAllData();
        response.statusCode(200).log().ifValidationFails();
        response.body("data.jackpotId", equalTo("Roxor Progressives"));
    }

    @Title("Verify if Id name is same")
    @Test
    public void test003() {
        response = virginGamesInfoSteps.getAllData();
        HashMap<String, Object> listOfJackpot = response.extract().path("data.pots[0]");
        Assert.assertThat(listOfJackpot, hasValue("play-around-the-reels-jackpot"));
    }

}
