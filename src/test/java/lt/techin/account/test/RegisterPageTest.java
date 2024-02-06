package lt.techin.account.test;

import lt.techin.account.page.HomePage;
import lt.techin.account.page.RegisterPage;
import lt.techin.account.test.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}



