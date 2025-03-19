package Testpages;

import BaseTest.BaseTest;
import Pages.Loginpage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.LoginDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
    public void validLoginTest(String username, String password) {
        Loginpage loginPage = new Loginpage(driver);
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed for valid user: " + username);
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class)
    public void invalidLoginTest(String username, String password) throws InterruptedException {
        Loginpage loginPage = new Loginpage(driver);
        loginPage.login(username, password);





        String actualValidation= loginPage.checkUrl();
        String expectedvalidation="Invalid credentials";

        Assert.assertEquals(actualValidation,expectedvalidation,"issue in a invalid login ");

    }}

