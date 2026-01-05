package tests;

import config.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

public class PerformanceGlitchUserPurchaseTest extends Setup {

    @Test(priority = 1, description = "Verify performance_glitch_user can complete a full purchase journey")
    public void verifyPerformanceGlitchUserPurchaseFlow() {
        // Initialize pages
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        // Login
        loginPage.login("performance_glitch_user", "secret_sauce");

        // Sort products Z to A and add products
        homePage.sortProductsZToA();
        homePage.productAddAfterSorting();
        Assert.assertEquals(homePage.getCartBadgeCount(), "2", "Cart should contain 2 items");

        homePage.openCart();
        checkoutPage.removeRedShirt();
        Assert.assertEquals(homePage.getCartBadgeCount(), "1", "Cart should contain 1 item");

        cartPage.continueShopping();
        homePage.addProductsToCart();
        Utils.scroll(driver, 500);
        Assert.assertEquals(homePage.getCartBadgeCount(), "4", "Cart should contain 4 items");

        homePage.openCart();
       Utils.scroll(driver, 500);
        cartPage.checkout();

        // Checkout info
        checkoutPage.enterDetails("Test", "User", "1212");
        Assert.assertEquals(checkoutPage.getItemTotal(), "Item total: $71.96", "Item total mismatch");

        // Finish purchase
        checkoutPage.finishCheckout();
        Assert.assertEquals(confirmationPage.getSuccessMessage(), "Thank you for your order!", "Success message mismatch");

        // Back to products & logout
        confirmationPage.backToProducts();
        homePage.logout();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "Login", "User should be logged out and see the Login button");
    }
}
