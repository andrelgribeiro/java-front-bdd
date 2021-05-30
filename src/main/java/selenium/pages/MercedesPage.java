package selenium.pages;

import java.io.IOException; 
import selenium.elements.MercedesElements;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;



public class MercedesPage extends BasePage {
    private static JavascriptExecutor jse = (JavascriptExecutor)driver;


    public static void acessarHatchs(String url) throws Exception {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#uc-banner-modal #uc-btn-accept-banner")).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,900)");
        Thread.sleep(2000);
        driver.switchTo().frame("vmos-cont");
        driver.findElement(By.cssSelector("[role='list'] button:first-of-type")).click();


    }
    public static void selecionarModeloAClass() throws Exception {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("section .vmos_m-GuR:first-of-type"))).build().perform();
        Thread.sleep(1000);

    }

    public static void selecionarCarroX() throws Exception {
        driver.findElement(By.cssSelector(".vmos_m-GuR .vmos_3HxTq.undefined:first-of-type")).click();
        Thread.sleep(15000);
    }

    public static void selecionarCombustivelDiesel() throws Exception {
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'Diesel')]")).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,250)");
    }
    
    public static void criarPrint() throws Exception {
        SeleniumUtils.getScreenShot(driver, "results/filter-diesel.png");
        Thread.sleep(2000);
    }

    public static void criarArquivoComparador() throws Exception {
        WebElement slider = driver.findElement(By.cssSelector("cc-slave-slider .cc-slider__slides"));
        ArrayList<String> ordenados = new ArrayList<>();
        List<WebElement> precos  = new ArrayList<>();
        int max = Integer.parseInt((driver.findElement(By.cssSelector(".cc-motorization-comparsion-status__info-text")).getText()).substring(0,2).trim());
        Thread.sleep(1000);
        for (int i = 1; i < max-3 ; i++) {
            precos = slider.findElements(By.cssSelector(".cc-motorization-header__price"));
            for (WebElement element : precos) {
                System.out.println("Prices text:" + element.getText());
                if (element.getText().contains("£")) {
                    ordenados.add(element.getText());
                }
            }
            driver.findElement(By.cssSelector(".cc-slider-buttons--design-circle .cc-slider-buttons__button--left")).click();
            Thread.sleep(2000);
        }
        Collections.sort(ordenados);
        System.out.println("Ordereds Prices text:" + ordenados);
        SeleniumUtils.writeFilePriceResult("The min and max prices are: " + ordenados.get(0) + " - " + ordenados.get(ordenados.size()-1));
        driver.close();
    }

}
