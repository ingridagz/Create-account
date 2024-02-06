package lt.techin.account.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement eMail;
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmPassword;
    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement registerButton;
    @FindBy(xpath = "//b[.='User account created successfully']")
    WebElement errorRegistration;
    @FindBy(xpath = "//form/div[1]/div[1]/div[1]/div[@class='invalid-feedback']")
    WebElement errorEmail;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement errorEmptyRegistration;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    List<WebElement> registrationErrorMessages;

    public void fillEmail(String emailField) {
        eMail.sendKeys(emailField);
    }

    public void fillName(String nameField) {
        name.sendKeys(nameField);
    }

    public void fillPassword(String passwordName) {
        password.sendKeys(passwordName);
    }

    public void confirmPassword(String confirmField) {
        confirmPassword.sendKeys(confirmField);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public String errorMessageRegistration() {
        return errorRegistration.getText();
    }

    public String randomEmailGenerator() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(50);
        return ("Inga" + randomInt + "@one.lt");
    }

    public String errorMessageEmail() {
        return errorEmail.getText();
    }

    public boolean isEmptyForm() {
        return errorEmptyRegistration.isDisplayed();
    }

    public boolean isMessageCsv(String errorMessageText) {
        ArrayList<String> newErrorMessages= new ArrayList<>();
        for (WebElement errorMessage : registrationErrorMessages) {
            newErrorMessages.add(errorMessage.getText());
        }
        return newErrorMessages.contains(errorMessageText);
    }

}

