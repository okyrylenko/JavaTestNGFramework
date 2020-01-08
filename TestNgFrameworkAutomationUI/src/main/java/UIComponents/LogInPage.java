package UIComponents;

import Foundation.BasePage;
import Foundation.models.Account;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Singleton;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class LogInPage extends BasePage {
   // @Inject
    public LogInPage(WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    private final By inptEmail = locateElementByCss("input#login_field");
    private final By inptPassword = locateElementByCss("input#password");
    private final By btnSignIn = locateElementByCss("input[name='commit']");

    public LogInPage logIn(Account account){
        this.enterEmail(account.getEmail());
        this.enterPassword(account.getPassword());
        this.clickSingIn();
        return this;
    }

    private void enterEmail(String email){
        sendKeys(inptEmail,email);
    }

    private void enterPassword(String password){
        sendKeys(inptPassword,password);
    }

    private void clickSingIn(){
        click(btnSignIn);
    }

}
