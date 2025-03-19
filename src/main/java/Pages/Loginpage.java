package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Locators
    private By usernameField = By.xpath("//input[contains(@name,'username')]");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By validationMessage = By.xpath("//p[contains(.,'Invalid credentials')]");
    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Initialize WebDriverWait
    }

    // Method to enter username
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear();  // Clear existing value, if any
        usernameElement.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    // Method to perform login action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Method to verify successful login (can be improved)
    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.urlContains("dashboard")); // Adjust this URL fragment
    }

    public String checkUrl(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


return wait.until(ExpectedConditions.visibilityOf(driver.findElement(validationMessage))).getText();


    }

}
