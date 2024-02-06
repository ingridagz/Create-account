package lt.techin.account.test;

import lt.techin.account.page.HomePage;
import lt.techin.account.page.LoginPage;
import lt.techin.account.page.RegisterPage;
import lt.techin.account.test.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BasePageTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private final String name = "Inga";
    private final String password = "666666";

    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    void goToLoginPage() {
        homePage.clickCreateAccount();

        String getRandomEmail = RandomEmail.getRandomEmail();
        registerPage.fillEmail(getRandomEmail);
        System.out.println(getRandomEmail);
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();

        loginPage.clickLoginFirst();
        loginPage.fillLoginEmail(getRandomEmail);
        System.out.println(getRandomEmail);
        loginPage.fillLoginPassword(password);
        loginPage.clickLoginSecond();

        Assertions.assertTrue(loginPage.isThereLogoutButton());
        System.out.println(loginPage.isThereLogoutButton());

        loginPage.clickLogout();
    }

    @Test
    void goToLoginPageWithWrongPassword() {

        homePage.clickCreateAccount();

        String getRandomEmail = RandomEmail.getRandomEmail();
        registerPage.fillEmail(getRandomEmail);
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();

        loginPage.clickLoginFirst();
        loginPage.fillLoginEmail(getRandomEmail);
        loginPage.fillLoginPassword("555555");
        loginPage.clickLoginSecond();

        Assertions.assertEquals("Incorrect email address or password", loginPage.errorMessageEmail());
    }

    @Test
    void goToProfileCheckEmail() {
        homePage.clickCreateAccount();

        String getRandomEmail = RandomEmail.getRandomEmail();
        registerPage.fillEmail(getRandomEmail);
        registerPage.fillName(name);
        registerPage.fillPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegister();

        loginPage.clickLoginFirst();
        loginPage.fillLoginEmail(getRandomEmail);
        loginPage.fillLoginPassword(password);
        loginPage.clickLoginSecond();

        loginPage.clickProfile();
        Assertions.assertEquals(getRandomEmail, loginPage.getProfileEmail());
    }
}
