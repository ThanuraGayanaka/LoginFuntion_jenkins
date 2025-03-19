package utilities;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"admin", "admin123"},

        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][]{
                {"invalidUser", "admin123"},
                {"admin", "wrongPass"},
                {"", ""},
                {"admin", ""},
                {"", "admin123"}
        };
    }
}
