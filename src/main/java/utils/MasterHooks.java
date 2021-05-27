package selenium.pages;

import cucumber.api.Scenario; 
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import utils.SeleniumUtils;



public class MasterHooks  extends BasePage {

    @Before
    public void setup() throws IOException {
        driver = SeleniumUtils.iniciaDriver();
        System.out.println("----DRIVER: " + driver);
    }

    @After
    public void tearDownAndScreenshotOnFailure(Scenario scenario) {
        
    }
}