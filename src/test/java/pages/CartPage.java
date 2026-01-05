package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    // ✅ Using @FindBy instead of By
    @FindBy(css = "[data-test='checkout']")
    private WebElement checkoutBtn;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;

    // ✅ Constructor

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    // ✅ Methods to perform actions
    public void checkout() {
        checkoutBtn.click();
    }

    public void continueShopping() {
        continueShoppingBtn.click();
    }
}