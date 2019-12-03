import Foundation.BaseTest;
import Foundation.Browser;
import Foundation.dataRepository.DataProvidersFactory;
import Foundation.dataRepository.DataSupplier;
import Foundation.models.Account;
import Foundation.utils.Retry;
import Foundation.utils.TestNGListeners;
import UIComponents.HomePage;
import UIComponents.LogInPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

//@Guice(modules = LogInPage.class)
public class LogInFail extends BaseTest {

    // @Inject
    // private LogInPage logInPage;

    @Test(groups = {"smoke", "regression"},dataProvider = DataProvidersFactory.allAccounts, dataProviderClass = DataSupplier.class)
    public void shouldBeAbleToLogIn(Account[] accounts) throws IOException {
        LogInPage logInPage = new LogInPage(driver, wait);
        Browser browser = new Browser(driver, wait);
        browser.navigateTo("loginf");
        logInPage.logIn(Arrays.asList(accounts).get(0));
    }

    @Test(retryAnalyzer = Retry.class)
    public void shouldBeAbleToSearch(){
        HomePage homePage = new HomePage(driver, wait);
        Browser browser = new Browser(driver, wait);

        browser.navigateTo("ffsdffsfsffff");

        homePage.header().search("Selenium");
    }
}