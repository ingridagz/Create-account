package lt.techin.account.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath= "//input[@id='confirmPassword']")
    WebElement confirmPassword;
    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement registerButton;
    @FindBy(xpath="//b[.='User account created successfully']")
    WebElement message;

    public void fillEmail(String emailField) {
        eMail.sendKeys(emailField);
    }
    public void fillName(String nameField) {
        name.sendKeys(nameField);
    }
   public void fillPassword(String passwordName){
        password.sendKeys(passwordName);
    }
    public void confirmPassword(String confirmField) {
        confirmPassword.sendKeys(confirmField);
    }
    public void clickRegister() {
        registerButton.click();
    }
    public String errorMessageAppear(){
        return message.getText();
    }
    public String randomEmailGenerator(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(20);
        return ("Inga"+randomInt + "@one.lt");
    }
}
