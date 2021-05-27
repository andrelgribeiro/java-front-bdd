package selenium.pages;

import java.io.IOException; 
import selenium.elements.MercedesElements;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;



public class MercedesPage extends BasePage {

    public static void acessarHatchs(String url) throws Exception {
        //driver = SeleniumUtils.iniciaDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#uc-banner-modal #uc-btn-accept-banner")).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,700)");
        driver.switchTo().frame("vmos-cont");
        driver.findElement(By.cssSelector("[role='list'] button:first-of-type")).click();


    }
    public static void selecionarModeloAClass() throws Exception {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("section .vmos_m-GuR:first-of-type"))).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".vmos_m-GuR .vmos_3HxTq.undefined:first-of-type")).click();
        Thread.sleep(20000);
        driver.close();
    }

    public static void selecionarCarroX() throws Exception {
    }
    
    public static void criarPrint() throws Exception {
    }

}
