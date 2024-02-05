package lt.techin.account.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = " .btn.btn-lg.btn-outline-secondary")
    WebElement createAccountButton;

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
