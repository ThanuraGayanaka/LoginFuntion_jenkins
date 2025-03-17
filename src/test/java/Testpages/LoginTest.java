package Testpages;

import BaseTest.BaseTest;
import Pages.Loginpage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CSVUtility;
import utilities.ConfigReader;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] logindataProvider() throws IOException {

        return CSVUtility.readCSV("src/main/resources/testData.csv");
    }



    @BeforeTest
    @Override
    public void setup() throws InterruptedException {
        super.setup();

        Thread.sleep(3000);
    }

@Test(dataProvider = "loginData")
    public void loginFunction(String username,String password) throws InterruptedException {

        Loginpage loginpage= new Loginpage(driver);
        loginpage.login(username, password);
        Thread.sleep(3000);


        Assert.assertTrue(
                loginpage.isLoginSuccessful(),
                "Login failed for user: " + username);




    }



    @Test
    public void testInvalidLogin() {
        // Test case for invalid login can be added separately if needed.
        // Example: Provide invalid credentials and assert failure
    }
}
