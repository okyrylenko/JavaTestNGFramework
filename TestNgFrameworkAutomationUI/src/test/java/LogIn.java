import Foundation.BaseTest;
import Foundation.dataRepository.DataProvider;
import Foundation.models.Account;
import UIComponents.HomePage;
import UIComponents.LogInPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Guice(modules = LogInPage.class)
public class LogIn extends BaseTest {

   // @Inject
   // private LogInPage logInPage;

    @Test
    public void shouldBeAbleToLogIn() throws IOException {
        LogInPage logInPage = new LogInPage(driver, wait);
        driver.get("https://github.com/login");
        logInPage.logIn(DataProvider.getAccounts().get(0));
    }

    @Test
    public void shouldBeAbleToSearch(){
        HomePage homePage = new HomePage(driver, wait);

        driver.get("https://github.com");

        homePage.header().search("Selenium");
    }
}
