package selenium.pages;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java8.Pt;
import org.json.simple.JSONObject;
import selenium.pages.MercedesPage;
import java.lang.Math;
import selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import selenium.pages.MercedesPage;


import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class MercedesSteps extends BasePage implements Pt {


    public MercedesSteps() {

        Dado("que eu acesse a pagina da mercedes e click em hatchbacks", () -> {
            System.out.println("----DRIVER: " + driver);

            MercedesPage.acessarHatchs("https://www.mercedes-benz.co.uk");
        });      

        Quando("selecionar o modelo A-class", () ->{
            MercedesPage.selecionarModeloAClass();
        });

        Quando("selecionar a opcao build your car", () ->{
            MercedesPage.selecionarCarroX();
        });
        
        Então("crio e salvo o print", () ->{
            MercedesPage.criarPrint();
        });
        
    }
}