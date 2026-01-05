package tests;
import config.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class StandardUserPurchaseTest extends Setup {

    @Test(priority = 1, description = "Verify standard_user can complete a full purchase journey")
    public void verifyStandardUserPurchaseFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");


        // Add products
        homePage.addProductsToCart();
        Assert.assertEquals(homePage.getCartBadgeCount(), "3", "Cart should contain 3 items");

        // Checkout
        homePage.openCart();
        cartPage.checkout();

        checkoutPage.enterDetails("Test", "User", "1212");
        Assert.assertEquals(checkoutPage.getItemTotal(), "Item total: $55.97", "Item total mismatch");

        checkoutPage.finishCheckout();
        Assert.assertEquals(confirmationPage.getSuccessMessage(), "Thank you for your order!", "Success message mismatch");

        confirmationPage.backToProducts();
        homePage.logout();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "Login", "User should be logged out and see the Login button");
    }
}

