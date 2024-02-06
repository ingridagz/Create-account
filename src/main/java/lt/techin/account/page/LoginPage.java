package lt.techin.account.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = "[class='text-decoration-none me-3']")
    WebElement loginFirstButton;
    @FindBy(xpath = "/html//input[@id='email']")
    WebElement loginEmail;
    @FindBy(xpath = "/html//input[@id='password']")
    WebElement loginPassword;
    @FindBy(css = "[class='btn btn-lg btn-primary d-block w-100']")
    WebElement loginSecondButton;
    @FindBy(css = ".btn.btn-outline-danger")
    WebElement logoutButton;
    @FindBy(css = "[class] .d-flex")
    WebElement errorLoginPassword;
    @FindBy(xpath = "//a[@href='/notes/app/profile']")
    WebElement profileButton;
   @FindBy(css = "input#user-email")
   WebElement profileEmail;
    public void clickLoginFirst() {
       loginFirstButton.click();
    }
    public void fillLoginEmail(String loginEmailField) {
        loginEmail.sendKeys(loginEmailField);
    }
    public void fillLoginPassword(String loginPasswordField) {
        loginPassword.sendKeys(loginPasswordField);
    }
    public void clickLoginSecond() {
        loginSecondButton.click();
    }
    public boolean isThereLogoutButton(){
        return logoutButton.isDisplayed();
    }
    public void clickLogout() {
        logoutButton.click();
    }
    public String errorMessageEmail(){
        return errorLoginPassword.getText();
    }
    public void clickProfile() {
        profileButton.click();
    }

public String getProfileEmail(){
        return profileEmail.getAttribute("value");
}




}
