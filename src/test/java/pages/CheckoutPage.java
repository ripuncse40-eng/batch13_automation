package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    // ✅ Using @FindBy instead of By
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(css = "[data-test='subtotal-label']")
    private WebElement itemTotal;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    private WebElement removeRedShirt;

    // ✅ Constructor
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ✅ Methods to perform actions
    public void enterDetails(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueBtn.click();
    }

    public String getItemTotal() {
        return itemTotal.getText();
    }

    public void removeRedShirt() {
        removeRedShirt.click();
    }

    public void finishCheckout() {
        finishBtn.click();
    }
}
