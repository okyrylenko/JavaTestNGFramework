import Foundation.BaseTest;
import Foundation.Browser;
import Foundation.dataRepository.DataProvidersFactory;
import Foundation.dataRepository.DataSupplier;
import Foundation.models.Account;
import Foundation.utils.TestNGListeners;
import UIComponents.HomePage;
import UIComponents.LogInPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

//@Guice(modules = LogInPage.class)
public class LogIn extends BaseTest {

   // @Inject
   // private LogInPage logInPage;

    @Test(dataProvider = DataProvidersFactory.allAccounts, dataProviderClass = DataSupplier.class, groups = {"smoke"})
    public void shouldBeAbleToLogIn(Account[] accounts) throws IOException {
        LogInPage logInPage = new LogInPage(driver, wait);
        Browser browser = new Browser(driver, wait);
        browser.navigateTo("login");
        logInPage.logIn(Arrays.asList(accounts).get(0));
    }

    @Test(groups = {"smoke, regression"})
    public void shouldBeAbleToSearch(){
        HomePage homePage = new HomePage(driver, wait);
        Browser browser = new Browser(driver, wait);
        browser.navigateTo("login");

        homePage.header().search("Selenium");
    }
}
