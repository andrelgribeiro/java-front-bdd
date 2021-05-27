package steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java8.Pt;
import org.json.simple.JSONObject;
import selenium.pages.MercedesPage;
import java.lang.Math;


import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class MercedesSteps implements Pt {


    public MercedesSteps() {

        Dado("que eu acesse a pagina da mercedes e click em hatchbacks", () -> {
            MercedesPage.acessarHatchs("https://www.mercedes-benz.co.uk/passengercars.html");
        });      
    }
}