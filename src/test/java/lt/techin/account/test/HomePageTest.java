package lt.techin.account.test;

import lt.techin.account.page.HomePage;
import lt.techin.account.page.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BasePageTest {
    private HomePage homePage;

    @BeforeEach
    void setUp(){
        homePage=new HomePage(driver);
    }

    @Test
    void goToRegistrationPage() {
        homePage.clickCreateAccount();
    }
}
