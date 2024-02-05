package lt.techin.account.test;

import lt.techin.account.page.HomePage;
import lt.techin.account.page.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterPageTest extends BasePageTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    void userRegistration() {
        homePage.clickCreateAccount();

        String randomEmail = registerPage.randomEmailGenerator();
        System.out.println(randomEmail);

        registerPage.fillEmail(randomEmail);
        registerPage.fillName("Inga");
        registerPage.fillPassword("6666666");
        registerPage.confirmPassword("6666666");
        registerPage.clickRegister();
        Assertions.assertEquals("User account created successfully", registerPage.errorMessageAppear());
    }

    @Test
    void userLogin() {


    }


}



