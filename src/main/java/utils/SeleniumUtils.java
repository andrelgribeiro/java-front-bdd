package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public static WebDriver driver;

    public SeleniumUtils() {

    }

public static String getChromeDriverPath() {
    String OS = System.getProperty("os.name");

    if (OS.contains("Window")) {
        return "driver/chromedriver.exe";
    } else if (OS.contains("Mac")) {
        return "driver/chromedriver_mac";
    } else {
        return "driver/chromedriver_linux";
    }
}

    public static WebDriver iniciaDriver() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
    public static void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void sleeps(long segundos) throws InterruptedException {
        Thread.sleep(segundos * 1000);
    }

    public static void clickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

}
