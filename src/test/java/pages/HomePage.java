package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;

    // ✅ Burger menu and navigation
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateLink;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeMenuBtn;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    // ✅ Product buttons
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tshirtAddToCart;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement redTshirtAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacketAddToCart;

    // ✅ Constructor
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ✅ Methods
    public void resetAppState() {
        burgerMenuBtn.click();
        resetAppStateLink.click();
        closeMenuBtn.click();
    }

    public void addProductsToCart() {
        backpackAddToCart.click();
        bikeLightAddToCart.click();
        tshirtAddToCart.click();
    }

    public void productAddAfterSorting() {
        redTshirtAddToCart.click();
        fleeceJacketAddToCart.click();
    }

    public String getCartBadgeCount() {
        return cartBadge.getText();
    }

    public void sortProductsZToA() {
        Select dropdownSelect = new Select(sortDropdown);
        dropdownSelect.selectByValue("za"); // Select Z → A
    }

    public void openCart() {
        cartLink.click();
    }

    public void logout() {
        burgerMenuBtn.click();
        logoutLink.click();
    }
}
