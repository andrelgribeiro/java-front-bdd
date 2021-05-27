package selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;



public class MercedesPage {
    static WebDriver driver;

    public static void acessarHatchs(String url) throws Exception {
        driver = SeleniumUtils.iniciaDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get(url);

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#uc-banner-modal #uc-btn-accept-banner")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector("#hatchback-portaledId button")).click();

        driver.close();
        }

}
