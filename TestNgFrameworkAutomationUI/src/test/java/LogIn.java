import Foundation.BaseTest;
import Foundation.Browser;
import Foundation.dataRepository.DataProvidersFactory;
import Foundation.dataRepository.DataSupplier;
import Foundation.models.Account;
import Foundation.models.RepositorySearchResult;
import Foundation.utils.TestGroups;
import Foundation.utils.TestNGListeners;
import Foundation.utils.ThreadManager;
import UIComponents.HomePage;
import UIComponents.LogInPage;
import UIComponents.ReposList;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//@Guice(modules = LogInPage.class)
public class LogIn extends BaseTest {

   // @Inject
   // private LogInPage logInPage;

    @Test(dataProvider = DataProvidersFactory.allAccounts, dataProviderClass = DataSupplier.class, groups = {"smoke"})
    public void shouldBeAbleToLogIn(Account[] accounts) throws IOException {
        LogInPage logInPage = new LogInPage(ThreadManager.getDriver(), ThreadManager.getWait());
        HomePage homePage = new HomePage(ThreadManager.getDriver(), ThreadManager.getWait());
        Browser browser = new Browser(ThreadManager.getDriver(), ThreadManager.getWait());
        browser.navigateTo("login");
        logInPage.logIn(Arrays.asList(accounts).get(0));

        Assert.assertTrue(homePage.header().isAccountIconVisible());
    }

    @Test(groups = {TestGroups.SMOKE, TestGroups.REGRESSION})
    public void shouldBeAbleToSearch(){
        HomePage homePage = new HomePage(ThreadManager.getDriver(), ThreadManager.getWait());
        Browser browser = new Browser(ThreadManager.getDriver(), ThreadManager.getWait());
        ReposList repos = new ReposList(ThreadManager.getDriver(), ThreadManager.getWait());
        browser.navigateTo("/");

        homePage.header().search("selenium");

        HashSet<RepositorySearchResult> actual = repos.getAllResults();
        for(RepositorySearchResult repo: actual){
            Assert.assertTrue(repo.getLanguages().stream().filter(r->r.toString().toLowerCase().contains("selenium")).count()>0);
        }
    }
}
