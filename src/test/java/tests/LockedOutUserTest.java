package tests;

import config.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LockedOutUserTest extends Setup {

    @Test(priority = 1, description = "Verify Swag Labs homepage loads successfully")
    public void verifyHomePageTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Homepage title mismatch");
    }

    @Test(priority = 2, description = "Verify locked_out_user cannot login and error message is shown")
    public void verifyLockedOutUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message mismatch for locked_out_user");
    }
}
