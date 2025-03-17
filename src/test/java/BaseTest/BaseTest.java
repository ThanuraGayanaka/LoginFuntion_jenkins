package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.ConfigReader;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
   protected WebDriverWait wait;

@BeforeTest
    public void setup() throws InterruptedException {

        WebDriverManager .chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getAppUrl());



    }
@AfterTest
    public void Teardwon(){

        if (driver!=null){

            driver.quit();
        }


    }


}
