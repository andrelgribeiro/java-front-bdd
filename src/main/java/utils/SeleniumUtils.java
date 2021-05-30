package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;





import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public static WebDriver driver;

    public SeleniumUtils() {

    }

public static String getDriverPath() {
    String OS = System.getProperty("os.name");
    String browser = System.getProperty("browserOption");
    if (browser.contains("firefox")) {
        if (OS.contains("Window")) {
            return "driver/geckodriver.exe";
        } else if (OS.contains("Mac")) {
            return "driver/geckodriver_mac";
        } else {
            return "driver/geckodriver_linux";
        }
    }
    else if (browser.contains("safari")) {
        if (OS.contains("mac")) {
            return "";
        } else {
            return "driver/chromedriver.exe";
        }
    }
    else {
        if (OS.contains("Window")) {
            return "driver/chromedriver.exe";
        } else if (OS.contains("Mac")) {
            return "driver/chromedriver_mac";
        } else {
            return "driver/chromedriver_linux";
        }
    }
}
    public static void getScreenShot(WebDriver driver, String fileName) {
        try {
            File f = new File(fileName);
            f.getParentFile().mkdirs(); 
            if(!f.exists()){
                f.createNewFile();
            }else{
                System.out.println("File already exists");
                f.delete();
                f.createNewFile();
            }
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory with name "screenshot.png"
            FileHandler.copy(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public static void writeFilePriceResult(String results) {
        File file = new File("results/price-results.txt");
        file.getParentFile().mkdirs(); 
        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
            } else {
                System.out.println("File already exists.");
                file.delete();
                file.createNewFile();
            }
            //Write Content
            FileWriter writer = new FileWriter(file);
            writer.write(results);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver iniciaDriver() {
        String browser = System.getProperty("browserOption");

        if (browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver", getDriverPath());
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
        }
        else if (browser.contains("safari")){
            WebDriver driver = new SafariDriver();
            driver.manage().window().maximize();
            return driver;
        }
        else {
            System.setProperty("webdriver.chrome.driver", getDriverPath());
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-gpu");
            options.addArguments("window-size=1400,800");

            WebDriver driver = new ChromeDriver(options);
            return driver;
        }
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
