package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    private WebDriver driver;

    // ✅ Using @FindBy instead of By
    @FindBy(css = "[data-test='complete-header']")
    private WebElement successMessage;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsBtn;

    // ✅ Constructor
    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ✅ Methods to perform actions
    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void backToProducts() {
        backToProductsBtn.click();
    }
}

