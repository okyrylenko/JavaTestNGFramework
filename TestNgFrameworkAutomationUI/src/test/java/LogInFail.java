import Foundation.BaseTest;
import Foundation.Browser;
import Foundation.dataRepository.DataProvidersFactory;
import Foundation.dataRepository.DataSupplier;
import Foundation.models.Account;
import Foundation.utils.Retry;
import Foundation.utils.TestNGListeners;
import Foundation.utils.ThreadManager;
import UIComponents.HomePage;
import UIComponents.LogInPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.Arrays;

//@Guice(modules = LogInPage.class)
public class LogInFail extends BaseTest {

    // @Inject
    // private LogInPage logInPage;

    @Test(groups = {"smoke", "regression"},dataProvider = DataProvidersFactory.allAccounts, dataProviderClass = DataSupplier.class)
    public void shouldBeAbleToLogIn(Account[] accounts) throws IOException {
        LogInPage logInPage = new LogInPage(ThreadManager.getDriver(), ThreadManager.getWait());
        Browser browser = new Browser(ThreadManager.getDriver(), ThreadManager.getWait());
        browser.navigateTo("loginf");
        logInPage.logIn(Arrays.asList(accounts).get(0));
    }

    @Test(retryAnalyzer = Retry.class)
    public void shouldBeAbleToSearch(){
        HomePage homePage = new HomePage(ThreadManager.getDriver(), ThreadManager.getWait());
        Browser browser = new Browser(ThreadManager.getDriver(), ThreadManager.getWait());

        browser.navigateTo("");

        homePage.header().search("Selenium");
    }
}