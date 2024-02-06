package lt.techin.account.test;

import lt.techin.account.page.HomePage;
import lt.techin.account.page.RegisterPage;
import lt.techin.account.test.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import java.time.Duration;

public class RegisterPageTest extends BasePageTest {

    private HomePage homePage;
    private RegisterPage registerPage;
    private final String name="Inga";
    private final String password="666666";


    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    void userRegistration1() {
        homePage.clickCreateAccount();

        String randomEmail = registerPage.randomEmailGenerator();
        System.out.println(randomEmail);

        registerPage.fillEmail(randomEmail);
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();
        Assertions.assertEquals("User account created successfully", registerPage.errorMessageRegistration());
    }

    @Test
    void userRegistration2(){
        homePage.clickCreateAccount();

        String getRandomEmail = RandomEmail.getRandomEmail();
        System.out.println(getRandomEmail);

        registerPage.fillEmail(getRandomEmail);
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();
        Assertions.assertEquals("User account created successfully", registerPage.errorMessageRegistration());
    }

    @Test
    void userRegistrationWrongEmail(){
        homePage.clickCreateAccount();
        registerPage.fillEmail("111111111");
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();
        Assertions.assertEquals("Email address is invalid", registerPage.errorMessageEmail());
    }

    @Test
    void userEmptyRegistration(){
        homePage.clickCreateAccount();

        registerPage.clickRegister();
        Assertions.assertTrue(registerPage.isEmptyForm());
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/register.csv", numLinesToSkip = 1)
    void userRegistrationWithCsvFile(String emailCsv, String nameCsv, String passwordCsv, String passwordConfirmCsv, String messageErrCsv) {
        homePage.clickCreateAccount();

        registerPage.fillEmail(emailCsv);
        registerPage.fillName(nameCsv);
        registerPage.fillPassword(passwordCsv);
        registerPage.confirmPassword(passwordConfirmCsv);

        registerPage.clickRegister();

        Assertions.assertTrue(registerPage.isMessageCsv(messageErrCsv), "Error message: " + messageErrCsv);
        System.out.println("Error message: " + messageErrCsv);
    }
}



